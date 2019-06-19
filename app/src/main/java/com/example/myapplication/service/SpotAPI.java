package com.example.myapplication.service;

import com.example.myapplication.model.Spot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This class represents the spots API, all endpoints can stay here.
 */
public interface SpotAPI {

    @GET("development/scripts/get_map_pins.php")
    Call<List<Spot>> getListOfSpot();

}
