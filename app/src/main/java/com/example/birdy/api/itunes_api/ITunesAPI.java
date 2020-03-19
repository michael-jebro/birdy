package com.example.birdy.api.itunes_api;

import com.example.birdy.api.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITunesAPI extends API {
    public static final String ITUNES_URL = "https://itunes.apple.com/";
    public static final String MEDIA_TYPE = "music";
    public static final int MAX_LIMIT = 5;

    @GET("/search")
    public Call<ITunesResponseModel> getData(
            @Query("term") String textToSearch,
            @Query("limit") int resultsLimit,
            @Query("media") String media
    );

}
