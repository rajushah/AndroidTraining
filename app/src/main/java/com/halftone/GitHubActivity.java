package com.halftone;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.halftone.movie.R;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
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

        final Realm realm = Realm.getDefaultInstance();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);


        service.listRepos("Prabin01180").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                for (Repo repo : response.body()) {
                    realm.beginTransaction();
                    Repo realRepo = realm.createObject(Repo.class);

                    realRepo.setName(repo.getName());
                    realRepo.setDescription(repo.getDescription());

                    realm.commitTransaction();
                }


                RealmResults<Repo> repos = realm.where(Repo.class).findAll();

                for (Repo repo1 : repos) {
                    Log.d("repo", "" + repo1.getName());
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, GitHubActivity.class);
        context.startActivity(starter);
    }
}
