package com.example.birdy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.birdy.database.BirdyDBHelper;
import com.example.birdy.layout_entities.search_result_activity.SearchResultItem;

public class MainActivity extends AppCompatActivity {

    static final int SEARCH_REQUEST = 1;
    static final String ACTIVITY_TITLE = "Library";

    private void changeActivity(View v) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("search_text", ((EditText) v).getText().toString());
        this.startActivityForResult(intent, SEARCH_REQUEST);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(ACTIVITY_TITLE);
        //TO DO: db initialization

        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.searchField);

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    changeActivity(v);
                    handled = true;
                }
                return handled;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == SEARCH_REQUEST) {
                // TO DO: getting item info and putting it into a db
            }
        }
    }

    @Override
    protected void onDestroy() {
        BirdyDBHelper.getInstance(getApplicationContext()).close();
        super.onDestroy();
    }

}
