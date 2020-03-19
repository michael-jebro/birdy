package com.example.birdy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.birdy.api.itunes_api.ITunesAPI;
import com.example.birdy.api.InitAPIHandler;
import com.example.birdy.api.itunes_api.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultsActivity extends AppCompatActivity {
    static final String ITUNES_URL = "https://itunes.apple.com/";

    private com.example.birdy.api.APIController APIController;

    @BindView(R.id.resultsLayout)
        LinearLayout resultsLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String searchText = intent.getStringExtra("search_text");
        this.setTitle(searchText);
        ButterKnife.bind(this);

        Log.v("User_log", searchText);

    }

    private void displayResults(View v, List<Result> results) {}

    private void displayNoMatchResultsFound(View v) {}

    private void returnToLibrary(Bundle bundle) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void returnToLibrary() {
        setResult(RESULT_OK);
        finish();
    }

}
