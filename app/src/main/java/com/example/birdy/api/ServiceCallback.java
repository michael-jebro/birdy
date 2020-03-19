package com.example.birdy.api;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCallback<T extends ServiceResponseModel> implements Callback<T> {

    private Response<T> response;

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        this.response = response;
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("User_log", t.toString());
    }

    public Response<T> getResponse() { return response; }
}
