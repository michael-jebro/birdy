package com.example.birdy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.birdy.request.ITunesRequest;
import com.example.birdy.request.ITunesResponseModel;
import com.example.birdy.request.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchResultsActivity extends AppCompatActivity {

    static final String ITUNES_URL = "https://itunes.apple.com/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String searchText = intent.getStringExtra("search_text");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ITUNES_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        ITunesRequest request = retrofit.create(ITunesRequest.class);
        request.getData(searchText, 5, "music")
                .enqueue(new Callback<ITunesResponseModel>() {
                    @Override
                    public void onResponse(Call<ITunesResponseModel> call,
                                           Response<ITunesResponseModel> response) {
                        List<Result> results = response.body().getResults();

                        if (results != null) {
                            Log.v("User_log", results.get(0).getArtistName());
                        } else {
                            //TO DO: inform user about no matching results found
                        }
                    }

                    @Override
                    public void onFailure(Call<ITunesResponseModel> call, Throwable t) {
                        Log.e("User_log", t.getMessage());
                    }
                });

        Log.v("User_log", searchText);

    }

    public void returnWithResult() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("result_image", "...");
        setResult(RESULT_OK, intent);
        finish();
    }
}
