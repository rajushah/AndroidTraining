package com.halftone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halftone.movie.R;

public class MovieInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MovieInfoFragment()).commit();
    }
}
