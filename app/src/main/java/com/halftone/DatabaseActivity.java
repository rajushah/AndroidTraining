package com.halftone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halftone.movie.R;

import io.realm.Realm;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Realm realm = Realm.getDefaultInstance();
    }
}
