package com.example.friends.network;

import android.util.Log;

import com.example.friends.mainActivity.models.datamodels.MainDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements ApiService {

    private final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    private void apiError(String errorMessage) {
        Log.i("ApiError", "ApiError: " + errorMessage);
    }

    @Override
    public void getUser(ResponseCallback<MainDataModel> responseCallback) {

        Call<MainDataModel> call = apiInterface.getUser("10");
        call.enqueue(new Callback<MainDataModel>() {
            @Override
            public void onResponse(Call<MainDataModel> call, Response<MainDataModel> response) {
                if (response.code() == 200) {
                    responseCallback.onSuccess(response.body());
                } else {
                    responseCallback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<MainDataModel> call, Throwable t) {
                responseCallback.onError(t.getMessage());
            }
        });
    }


}
