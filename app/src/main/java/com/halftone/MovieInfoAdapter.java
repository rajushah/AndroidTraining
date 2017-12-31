package com.halftone;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.halftone.movie.R;

import java.util.List;


public class MovieInfoAdapter extends RecyclerView.Adapter<MovieInfoAdapter.MovieInfoViewHolder> {
    List<Movie> movies;
    private Context context;

    public MovieInfoAdapter(Context context, List<Movie> movies) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public MovieInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_info_adapter, parent, false);
        return new MovieInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieInfoViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(0).title);
        holder.movieReleaseDate.setText(movies.get(0).release_date);
        //GlideApp.with(this).load("http://goo.gl/gEgYUd").into(imageView);
        Glide.with(context).load("http://goo.gl/gEgYUd").into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieInfoViewHolder extends RecyclerView.ViewHolder {
        private TextView movieTitle;
        private TextView movieReleaseDate;
        private RatingBar movieRatingBar;
        private ImageView moviePoster;

        public MovieInfoViewHolder(View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieReleaseDate = itemView.findViewById(R.id.movie_release_date);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }
}
