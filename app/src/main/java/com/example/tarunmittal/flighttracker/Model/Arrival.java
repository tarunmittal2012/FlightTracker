package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class Arrival {
    @SerializedName("iataCode")
    private String iataCode;
    @SerializedName("icaoCode")
    @Expose
    private String icaoCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public Arrival() {
    }

    /**
     *
     * @param iataCode
     * @param icaoCode
     */
    public Arrival(String iataCode, String icaoCode) {
        super();
        this.iataCode = iataCode;
        this.icaoCode = icaoCode;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }


}
