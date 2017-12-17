package com.halftone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.halftone.movie.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);


        service.listRepos("rajushah").enqueue(new Callback<List<Shah>>() {
            @Override
            public void onResponse(Call<List<Shah>> call, Response<List<Shah>> response) {
                Log.d("shahs list ", "" + response.body().size());
            }

            @Override
            public void onFailure(Call<List<Shah>> call, Throwable t) {

            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, GitHubActivity.class);
        context.startActivity(starter);
    }
}
