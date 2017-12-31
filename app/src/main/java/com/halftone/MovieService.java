package com.halftone;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rajesh on 12/31/17.
 */

public interface MovieService {
    @GET("3/movie/popular?page=1&api_key=3d9f6ef05faa3072ee2caf7fb6870964")
    Call<MovieResult> getMovies();
}
