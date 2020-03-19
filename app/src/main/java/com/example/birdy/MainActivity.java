package com.example.birdy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.example.birdy.api.APIController;
import com.example.birdy.api.itunes_api.ITunesResponseModel;
import com.example.birdy.api.itunes_api.Result;
import com.example.birdy.database.BirdyDBHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    static final int SEARCH_REQUEST = 1;
    static final String ACTIVITY_TITLE = "Library";

    private APIController apiController;

    @BindView(R.id.searchField)
    EditText searchField;

    @OnEditorAction(R.id.searchField)
    public boolean onEditorAction(EditText v, int actionId, KeyEvent event) {
        boolean handled = false;
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            startSearchResultsActivity(v.getText().toString());
            handled = true;
        }
        return handled;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiController = APIController.getInstance();

        this.setTitle(ACTIVITY_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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
        super.onDestroy();
    }

    private void startSearchResultsActivity(String key) {
        Intent intent = new Intent(this, SearchResultsActivity.class);
        intent.putExtra("search_text", key);
        this.startActivityForResult(intent, SEARCH_REQUEST);
    }

}
