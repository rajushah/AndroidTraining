package com.halftone;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.halftone.movie.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieInfoFragment extends Fragment {

    private RecyclerView mRecyclerView;

    public MovieInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_info, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MovieService service = retrofit.create(MovieService.class);

        service.getMovies().enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                MovieInfoAdapter movieInfoAdapter = new MovieInfoAdapter(getContext(), response.body().results);
                mRecyclerView.setAdapter(movieInfoAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });

    }
}
