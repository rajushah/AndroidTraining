package com.halftone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.halftone.movie.MovieFragment;
import com.halftone.movie.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment(), "loginfragment").commit();

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment(), "loginfragment").commit();
            }
        });

        findViewById(R.id.sign_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new SignupFragment(), "signup").commit();
            }
        });


        findViewById(R.id.movie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MovieFragment(), "Movie").commit();
            }
        });

    }

    public static void start(Context context) {
        Intent starter = new Intent(context, FragmentActivity.class);
        context.startActivity(starter);
    }
}
