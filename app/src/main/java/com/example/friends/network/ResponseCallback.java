package com.example.friends.network;

public interface ResponseCallback <T> {

    void onSuccess(T data);
    void onError(String errorMessage);

}
