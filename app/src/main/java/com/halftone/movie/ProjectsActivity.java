package com.halftone.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectsActivity extends AppCompatActivity {
    public static final String TAG = ProjectsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);

        Call<List<Repo>> repos = service.listRepos("rajeshkumarkhadka");
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> projects = new ArrayList<>();
                projects.addAll(response.body());
                for (Repo repo : projects) {
                    Log.d(TAG, repo.name);
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });
    }


}
