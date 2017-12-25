package com.halftone.movie;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halftone.GithubService;
import com.halftone.Repo;
import com.halftone.RepoAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private RecyclerView recyclerView;

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        recyclerView = view.findViewById(R.id.rv_repos);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getRepository();
    }

    private void getRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GithubService service = retrofit.create(GithubService.class);
        service.listRepos("rajeshkumarkhadka").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                RepoAdapter repoAdapter = new RepoAdapter(response.body(), getActivity());
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(repoAdapter);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });
    }
}
