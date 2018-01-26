package com.example.chiriku_alii.gmovie.api;

import com.example.chiriku_alii.gmovie.model.GenreMovieResponse;
import com.example.chiriku_alii.gmovie.model.MovieResponse;
import com.example.chiriku_alii.gmovie.model.PopularMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by root on 11/28/17.
 */

public interface MovieApi {
    String apiKey = null;
    @GET("3/movie/popular?language=en-US&page=1")

    Call<PopularMovieResponse> getPopularMovies(
                        @Query("api_key") String apiKey,
                        @Query("page") String page);
    @GET("3/genre/movie/list?language=en-US")
    Call<GenreMovieResponse> getGenre(
                        @Query("api_key") String apiKey

            );
}
