package com.plaps.androidcleancode.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CityListData implements Parcelable{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("background")
    @Expose
    private String background;

    public CityListData(String id, String name, String description, String background) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.background = background;
    }


    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The background
     */
    public String getBackground() {
        return background;
    }

    /**
     *
     * @param background
     * The background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    public static final Creator<CityListData> CREATOR = new Creator<CityListData>() {
        @Override
        public CityListData createFromParcel(Parcel in) {
            return new CityListData(in);
        }

        @Override
        public CityListData[] newArray(int size) {
            return new CityListData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.background);
    }

    public CityListData(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.description = in.readString();
        this.background = in.readString();
    }
}
