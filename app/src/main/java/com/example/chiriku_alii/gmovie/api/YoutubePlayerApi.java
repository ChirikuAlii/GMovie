package com.example.chiriku_alii.gmovie.api;

import android.util.Log;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

/**
 * Created by root on 11/30/17.
 */

public class YoutubePlayerApi extends YouTubeBaseActivity {

    private static final String API_KEY = "AIzaSyBYkHIVo9WCYInB1eVTiasWgFlcfkzjReI";

    public static String getApiKey() {
        return API_KEY;
    }
}
