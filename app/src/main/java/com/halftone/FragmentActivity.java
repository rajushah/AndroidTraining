package com.halftone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halftone.movie.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }
    
    public static void start(Context context) {
        Intent starter = new Intent(context, FragmentActivity.class);
        context.startActivity(starter);
    }
}
