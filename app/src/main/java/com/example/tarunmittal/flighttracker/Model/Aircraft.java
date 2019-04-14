package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Aircraft {


    @SerializedName("regNumber")
    @Expose
    private String regNumber;
    @SerializedName("icaoCode")
    @Expose
    private String icaoCode;
    @SerializedName("icao24")
    @Expose
    private String icao24;
    @SerializedName("iataCode")
    @Expose
    private String iataCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public Aircraft() {
    }

    /**
     *
     * @param regNumber
     * @param iataCode
     * @param icao24
     * @param icaoCode
     */
    public Aircraft(String regNumber, String icaoCode, String icao24, String iataCode) {
        super();
        this.regNumber = regNumber;
        this.icaoCode = icaoCode;
        this.icao24 = icao24;
        this.iataCode = iataCode;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

}
