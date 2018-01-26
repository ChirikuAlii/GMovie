package com.example.chiriku_alii.gmovie.movie;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.chiriku_alii.gmovie.GMovie;
import com.example.chiriku_alii.gmovie.R;
import com.example.chiriku_alii.gmovie.api.YoutubePlayerApi;
import com.example.chiriku_alii.gmovie.model.GenreMovieModel;
import com.example.chiriku_alii.gmovie.model.MovieModel;
import com.example.chiriku_alii.gmovie.model.PopularMovieModel;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class DetailMovieActivity extends YouTubeBaseActivity {

    Toolbar toolbar;
    GenreMovieModel genreMovieModel ;
    PopularMovieModel popularMovieModel;

    TextView txtTitle ,txtDate,txtOverview;
    ImageView imageViewPoster ,imageViewBackdrop;
    YouTubePlayerView youTubePlayerView;
    YoutubePlayerApi youtubePlayerApi = new YoutubePlayerApi();
    YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        String title,date,overview, urlImage,urlBackdrop;

        txtTitle = findViewById(R.id.txt_view_detail_title);
        txtOverview =findViewById(R.id.txt_view_detail_synopsis);
        txtDate = findViewById(R.id.txt_view_detail_release_date);
        imageViewPoster = findViewById(R.id.image_view_detail_movie);
        imageViewBackdrop = findViewById(R.id.image_view_detail_movie2);

        Intent intent =getIntent();
        title= intent.getStringExtra("title");
        date= intent.getStringExtra("date");


         urlImage = intent.getStringExtra("urlimage");
        urlBackdrop= intent.getStringExtra("urlBackdrop");

        Glide.with(this).
                load("https://image.tmdb.org/t/p/w185"+urlImage).
                into(imageViewPoster);
        Glide.with(this).
                load("https://image.tmdb.org/t/p/w500"+urlBackdrop).
                into(imageViewBackdrop);

        txtTitle.setText(title);
        txtDate.setText(date);
        txtOverview.setText(""+popularMovieModel.getOriginalTitle());







    }
}
