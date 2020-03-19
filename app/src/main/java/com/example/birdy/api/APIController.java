package com.example.birdy.api;

import android.util.Log;

import androidx.annotation.Nullable;

import com.example.birdy.api.itunes_api.ITunesAPI;
import com.example.birdy.api.itunes_api.ITunesResponseModel;
import com.example.birdy.api.InitAPIHandler;
import com.example.birdy.api.itunes_api.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIController {

    private static APIController apiController;

    public static APIController getInstance() {
        if (apiController != null) {
            apiController = new APIController();
        }
        return apiController;
    }

    public Response<ITunesResponseModel> fetchDataFromITunes(String searchText) {
        InitAPIHandler initAPIHandler = new InitAPIHandler(ITunesAPI.class, ITunesAPI.ITUNES_URL);
        ITunesAPI api = (ITunesAPI) initAPIHandler.getAPI();

        ServiceCallback<ITunesResponseModel> serviceCallback =
                new ServiceCallback<ITunesResponseModel>();

        api.getData(searchText, ITunesAPI.MAX_LIMIT, ITunesAPI.MEDIA_TYPE).
                enqueue(serviceCallback);

        return serviceCallback.getResponse();
    }

    private APIController() {}

}
