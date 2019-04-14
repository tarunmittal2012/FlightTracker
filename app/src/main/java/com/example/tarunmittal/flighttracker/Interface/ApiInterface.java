package com.example.tarunmittal.flighttracker.Interface;

import com.example.tarunmittal.flighttracker.Model.Arrival;
import com.example.tarunmittal.flighttracker.Model.Data;
import com.example.tarunmittal.flighttracker.Model.Departure;
import com.example.tarunmittal.flighttracker.Model.Example;
import com.example.tarunmittal.flighttracker.Model.Flight;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
public interface ApiInterface {

    String BASE_URL="http://aviation-edge.com/v2/public";
    @GET("flights?key=9568a0-8ff8d3")
    Call<Data>getDepartureFlights(
                                           @Query("deplata")String deptString);
    @GET("flights?key=9568a0-8ff8d3")
    Call<Data>getArrivalFlights(
                                         @Query("arrIata")String arrivalString);
}
