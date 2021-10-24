package com.example.friends.mainActivity.views;

import com.example.friends.mainActivity.models.datamodels.MainDataModel;

public interface IMainView {

    void onListResponse(MainDataModel data);
    void onListError(String  errMessage);
}
