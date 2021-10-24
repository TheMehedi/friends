package com.example.friends.mainActivity.presenters;

import android.content.Context;

import com.example.friends.mainActivity.models.MainModel;
import com.example.friends.mainActivity.models.datamodels.MainDataModel;
import com.example.friends.mainActivity.views.IMainView;

public class MainPresenter implements IMainView {

    IMainView iMainView;
    Context context;

    public MainPresenter (Context context, IMainView iMainView){

        this.context = context;
        this.iMainView = iMainView;
    }

    @Override
    public void onListResponse(MainDataModel data) {

        iMainView.onListResponse(data);

    }

    @Override
    public void onListError(String errMessage) {

        iMainView.onListError(errMessage);
    }

    public void getUser(){

        MainModel.getUser(this);

    }

}
