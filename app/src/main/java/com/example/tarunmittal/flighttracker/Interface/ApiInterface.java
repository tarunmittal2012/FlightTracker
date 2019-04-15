package com.example.tarunmittal.flighttracker.Interface;

import com.example.tarunmittal.flighttracker.Model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface ApiInterface {

    String BASE_URL = "http://aviation-edge.com/v2/public";
    @GET("flights?key=9568a0-8ff8d3")
    Call<List<Example>> getDepartureFlights(
            @Query("depIata") String deptString);
    @GET("flights?key=9568a0-8ff8d3")
    Call<List<Example>> getArrivalFlights(
            @Query("arrIata") String arrivalString);
    @GET("flights?key=9568a0-8ff8d3")
    Call<List<Example>> getFlight(@Query("flightNum") String flightNum);

}
