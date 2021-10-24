package com.example.friends.network;

import com.example.friends.mainActivity.models.datamodels.MainDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/")
    Call<MainDataModel> getUser(@Query("results") String user);

}
