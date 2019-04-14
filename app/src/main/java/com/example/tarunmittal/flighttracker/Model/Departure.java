package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Departure {

    @SerializedName("iataCode")
    private String iataCode;

    @SerializedName("icaoCode")
    private String icaoCode;

    public String getIataCode() {

        return iataCode;
    }

    public String getIcaoCode() {

        return icaoCode;
    }
}