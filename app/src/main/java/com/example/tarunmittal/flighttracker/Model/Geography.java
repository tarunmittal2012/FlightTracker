package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Geography {

    @SerializedName("latitude")
    private Double latitude;

    @SerializedName("longitude")
    private Double longitude;

    @SerializedName("altitude")
    private Double altitude;

    public Double getLatitude() {

        return latitude;
    }

    public Double getLongitude() {

        return longitude;
    }

    public Double getAltitude() {

        return altitude;
    }

    public Double getDirection() {

        return direction;
    }

    @SerializedName("direction")

    private Double direction;

}