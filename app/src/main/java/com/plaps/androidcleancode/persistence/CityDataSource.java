package com.plaps.androidcleancode.persistence;

import java.util.List;

import io.reactivex.Flowable;

interface CityDataSource {
    /**
     * Gets the city from the data source.
     *
     * @return the city from the data source.
     */
    Flowable<List<City>> getCities();

    /**
     * Inserts the city into the data source, or, if this is an existing city, updates it.
     *
     * @param city the city to be inserted or updated.
     */
    void insertOrUpdateCity(City city);

    /**
     * Deletes all cities from the data source.
     */
    void deleteAllCities();
}
