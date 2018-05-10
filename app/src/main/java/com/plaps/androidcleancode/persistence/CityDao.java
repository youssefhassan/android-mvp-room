package com.plaps.androidcleancode.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Data Access Object for the cities table.
 */
@Dao
public interface CityDao {

    /**
     * Get the city from the table. Since for simplicity we only have one city in the database,
     * this query gets all cities from the table, but limits the result to just the 1st city.
     *
     * @return the city from the table
     */
    @Query("SELECT * FROM Cities")
    Flowable<List<City>> getCity();

    /**
     * Insert a city in the database. If the city already exists, replace it.
     *
     * @param city the city to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(City city);

    /**
     * Delete all cities.
     */
    @Query("DELETE FROM Cities")
    void deleteAllCities();
}
