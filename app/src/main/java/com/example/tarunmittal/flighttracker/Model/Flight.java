package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class Flight {

    @SerializedName("iataNumber")
    private String iataNumber;

    @SerializedName("icaoNumber")
    private String icaoNumber;

    @SerializedName("number")
    private String number;

    public String getIataNumber() {

        return iataNumber;
    }

    public String getIcaoNumber() {

        return icaoNumber;
    }

    public String getNumber() {

        return number;
    }
}