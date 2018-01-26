package com.example.chiriku_alii.gmovie.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenreMovieResponse implements Parcelable
{

    @SerializedName("genres")
    @Expose
    private List<GenreMovieModel> genres = null;
    public final static Parcelable.Creator<GenreMovieResponse> CREATOR = new Creator<GenreMovieResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public GenreMovieResponse createFromParcel(Parcel in) {
            return new GenreMovieResponse(in);
        }

        public GenreMovieResponse[] newArray(int size) {
            return (new GenreMovieResponse[size]);
        }

    }
            ;

    protected GenreMovieResponse(Parcel in) {
        in.readList(this.genres, (com.example.chiriku_alii.gmovie.model.GenreMovieModel.class.getClassLoader()));
    }

    public GenreMovieResponse() {
    }

    public List<GenreMovieModel> getGenreMovieModel() {
        return genres;
    }

    public void setGenreMovieModel(List<GenreMovieModel> genreMovieModel) {
        this.genres = genreMovieModel;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(genres);
    }

    public int describeContents() {
        return 0;
    }

}