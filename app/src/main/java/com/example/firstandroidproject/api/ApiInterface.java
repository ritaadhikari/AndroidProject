package com.example.firstandroidproject.api;

import retrofit2.Call;
import retrofit2.http.GET;

public class ApiInterface {
//    get ki post ho hya bhitra lekhni
    @GET('api/food')
    Call<FoodResponse> getFood();
}
