package com.example.tarunmittal.flighttracker.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Speed {
    @SerializedName("horizontal")
    private Double horizontal;
    @SerializedName("isGround")
    private Integer isGround;
    @SerializedName("vertical")
    private Double vertical;

    public Double getHorizontal() {

        return horizontal;
    }

    public Integer getIsGround() {

        return isGround;
    }

    public Double getVertical() {

        return vertical;
    }
}
