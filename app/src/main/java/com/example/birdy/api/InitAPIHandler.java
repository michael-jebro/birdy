package com.example.birdy.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InitAPIHandler {
    private Retrofit retrofit;
    private API api;

    public InitAPIHandler(Class<? extends API> clazz_api, String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(clazz_api);
    }

    public API getAPI() { return api; }
}
