package com.example.firstandroidproject.api;

import com.example.firstandroidproject.response.FoodResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
//    get ki post ho hya bhitra lekhni
    @GET("api/food")
    Call<FoodResponse> getFood();
}
