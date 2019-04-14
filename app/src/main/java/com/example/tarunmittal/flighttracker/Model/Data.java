package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
public class Data {

    @SerializedName("geography")
    public List<Geography> mGeographyList =null;

    @SerializedName("speed")
    public List<Speed> speedList = null;

    @SerializedName("departure")
    public List<Departure> departureList = null;

    @SerializedName("arrival")
    public List<Arrival> arrivalList = null;

    @SerializedName("aircraft")
    public List<Geography> aircraftList = null;

    @SerializedName("airline")
    public List<Speed> airlineList = null;

    @SerializedName("flight")
    public List<Departure> flightList = null;

    @SerializedName("system")
    public List<Arrival> systemList = null;

    @SerializedName("status")
    private String status;

}
