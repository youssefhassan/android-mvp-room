package com.plaps.androidcleancode.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * The Room database that contains the Cities table
 */
@Database(entities = {City.class}, version = 1, exportSchema = false)
public abstract class CitiesDatabase extends RoomDatabase {

    private static volatile CitiesDatabase INSTANCE;

    public abstract CityDao cityDao();

    public static CitiesDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (CitiesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        CitiesDatabase.class, "cities.db")
                        .allowMainThreadQueries()
                        .build();
                }
            }
        }
        return INSTANCE;
    }

}
