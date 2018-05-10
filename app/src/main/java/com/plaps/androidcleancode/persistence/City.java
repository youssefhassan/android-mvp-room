package com.plaps.androidcleancode.persistence;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

/**
 * Immutable model class for a City
 */
@Entity(tableName = "cities")
public class City {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "cityId")
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "background")
    private String background;

    City() {

    }

    @Ignore
    public City(String cityName, String description, String background) {
        id = UUID.randomUUID().toString();
        this.name = cityName;
        this.description = description;
        this.background = background;
    }

    public City(String id, String cityName, String description, String background) {
        this.id = id;
        this.name = cityName;
        this.description = description;
        this.background = background;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBackground() {
        return background;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}
