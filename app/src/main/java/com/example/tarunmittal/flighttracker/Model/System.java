package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class System {

    @SerializedName("updated")
    private String updated;
    @SerializedName("squawk")
    private String squawk;

    public String getUpdated() {

        return updated;
    }

    public String getSquawk() {

        return squawk;
    }
}