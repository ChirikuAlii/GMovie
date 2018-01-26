package com.example.chiriku_alii.gmovie.movie;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.chiriku_alii.gmovie.GMovie;
import com.example.chiriku_alii.gmovie.R;
import com.example.chiriku_alii.gmovie.model.GenreMovieModel;
import com.example.chiriku_alii.gmovie.model.GenreMovieResponse;
import com.example.chiriku_alii.gmovie.model.PopularMovieModel;
import com.example.chiriku_alii.gmovie.model.PopularMovieResponse;
import com.example.chiriku_alii.gmovie.utils.EndlessRecyclerViewScrollListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.util.Log.d;

public class MainActivity extends YouTubeBaseActivity {

    private  static  final String TAG=MainActivity.class.getName();

    RecyclerView recyclerView ;
    RecyclerViewAdapter adapter;
    List<PopularMovieModel> movieModelList = new ArrayList<>();
    List<GenreMovieModel> genreMovieModelsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new RecyclerViewAdapter(movieModelList,genreMovieModelsList);
        recyclerView = findViewById(R.id.recycler_movie);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        EndlessRecyclerViewScrollListener scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                loadMovie(""+(page+1));

            }
        };

        recyclerView.addOnScrollListener(scrollListener);

        loadMovie("1");
    }

  private void loadMovie(String page){


        GMovie.movieApi.getPopularMovies("3b980052023e8e6898f4578a6972740b" ,page).enqueue(new Callback<PopularMovieResponse>() {
            @Override
            public void onResponse(Call<PopularMovieResponse> call, Response<PopularMovieResponse> response) {
                d("tag","populer movie response :"+ new Gson().toJsonTree(response.body()));
                movieModelList.addAll(response.body().getResults());
                adapter.notifyDataSetChanged();
                //Log.d(TAG,"isinya genre"+movieModelList.get(0).getGenreIds());

            }

            @Override
            public void onFailure(Call<PopularMovieResponse> call, Throwable t) {

            }
        });
      GMovie.movieApi.getGenre("3b980052023e8e6898f4578a6972740b").enqueue(new Callback<GenreMovieResponse>() {
          @Override
          public void onResponse(Call<GenreMovieResponse> call, Response<GenreMovieResponse> response) {
              d("tag","populer genre response :"+ new Gson().toJsonTree(response.body()));

                genreMovieModelsList.addAll(response.body().getGenreMovieModel());
              //Log.d(TAG,"isinya genre"+genreMovieModelsList.get(0).getName());
          }

          @Override
          public void onFailure(Call<GenreMovieResponse> call, Throwable t) {

          }
      });

  }
}
