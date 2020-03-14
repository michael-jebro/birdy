package com.example.birdy.request;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ITunesRequest extends Request {
    @GET("/search")
    public Call<ITunesResponseModel> getData(
            @Query("term") String textToSearch,
            @Query("limit") int resultsLimit,
            @Query("media") String media
    );

}
