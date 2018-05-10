package com.plaps.androidcleancode.persistence;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Using the Room database as a data source.
 */
public class LocalCityDataSource implements CityDataSource {

    private final CityDao mCityDao;

    public LocalCityDataSource(CityDao cityDao) {
        mCityDao = cityDao;
    }

    @Override
    public Flowable<List<City>> getCities() {
        return mCityDao.getCity();
    }

    @Override
    public void insertOrUpdateCity(City city) {
        mCityDao.insertCity(city);
    }

    @Override
    public void deleteAllCities() {
        mCityDao.deleteAllCities();
    }
}
