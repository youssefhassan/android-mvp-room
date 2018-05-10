package com.plaps.androidcleancode.home

import com.plaps.androidcleancode.models.CityListData
import com.plaps.androidcleancode.models.CityListResponse
import com.plaps.androidcleancode.networking.NetworkError
import com.plaps.androidcleancode.networking.Service
import com.plaps.androidcleancode.persistence.CitiesDatabase
import com.plaps.androidcleancode.persistence.City
import com.plaps.androidcleancode.persistence.LocalCityDataSource
import rx.subscriptions.CompositeSubscription

/**
 * Created by ennur on 6/25/16.
 */
class HomePresenter(private val service: Service, private val view: HomeView) {
    private val subscriptions: CompositeSubscription = CompositeSubscription()

    fun getCityList() {
        view.showWait()

        val subscription = service.getCityList(object : Service.GetCityListCallback {
            override fun onSuccess(cityListResponse: CityListResponse) {
                persistData(cityListResponse.data)
                view.removeWait()
                view.getCityListSuccess(cityListResponse.data)
            }

            override fun onError(networkError: NetworkError) {
                retrieveFromDBIfExists()
                view.onFailure(networkError.appErrorMessage)
            }

        })

        subscriptions.add(subscription)
    }

    private fun retrieveFromDBIfExists() {
        val database = CitiesDatabase.getInstance(view.getContext())
        val dataSource = LocalCityDataSource(database.cityDao())

        dataSource.cities.map { cities ->
            val uiCities : MutableList<CityListData> = ArrayList()
            for (city in cities) {
                uiCities.add(CityListData(city.id, city.name, city.description, city.background))
            }
            view.removeWait()
            view.getCityListSuccess(uiCities)
        }.subscribe()

    }

    private fun persistData(data: MutableList<CityListData>) {
        val database = CitiesDatabase.getInstance(view.getContext())
        val dataSource = LocalCityDataSource(database.cityDao())

        dataSource.deleteAllCities()
        for (city in data) {
            val cityDb = City(city.id, city.name, city.description, city.background)
            dataSource.insertOrUpdateCity(cityDb)
        }

    }

    fun onStop() {
        subscriptions.unsubscribe()

    }
}
