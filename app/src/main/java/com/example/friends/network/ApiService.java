package com.example.friends.network;


import com.example.friends.mainActivity.models.datamodels.MainDataModel;

public interface ApiService {

    void getUser(ResponseCallback<MainDataModel> responseCallback);

}
