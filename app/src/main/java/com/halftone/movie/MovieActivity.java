package com.halftone.movie;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;


public class MovieActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MovieActivity.class);
        context.startActivity(starter);
    }
}
