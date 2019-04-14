package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Example {


    @SerializedName("geography")
    private Geography geography;
    @SerializedName("speed")
    private Speed speed;
    @SerializedName("departure")
    private Departure departure;
    @SerializedName("arrival")
    private Arrival arrival;
    @SerializedName("aircraft")
    private Aircraft aircraft;
    @SerializedName("airline")
    private Airline airline;
    @SerializedName("flight")
    private Flight flight;
    @SerializedName("system")
    private System system;
    @SerializedName("status")
    private String status;

    public Geography getGeography() {

        return geography;
    }

    public Speed getSpeed() {

        return speed;
    }

    public Departure getDeparture() {

        return departure;
    }

    public Arrival getArrival() {

        return arrival;
    }

    public Aircraft getAircraft() {

        return aircraft;
    }

    public Airline getAirline() {

        return airline;
    }

    public Flight getFlight() {

        return flight;
    }

    public System getSystem() {

        return system;
    }

    public String getStatus() {

        return status;
    }
}

