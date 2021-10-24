package com.example.friends.mainActivity.models;


import com.example.friends.mainActivity.models.datamodels.MainDataModel;
import com.example.friends.mainActivity.views.IMainView;
import com.example.friends.network.ApiService;
import com.example.friends.network.NetworkCall;
import com.example.friends.network.ResponseCallback;

public class MainModel {

    public static void getUser(IMainView iMainView){
        ApiService apiService = new NetworkCall();

        apiService.getUser(new ResponseCallback<MainDataModel>() {
            @Override
            public void onSuccess(MainDataModel data) {
                iMainView.onListResponse(data);
            }

            @Override
            public void onError(String errorMessage) {
                iMainView.onListError(errorMessage);
            }
        });

    }

}
