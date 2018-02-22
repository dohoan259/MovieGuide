package com.example.hoanbk.movieguide.data_manager.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

/**
 * Created by hoanbk on 01/02/2018.
 */

public class Movie implements Parcelable{

    private String mId;
    private String mOverView;
    @Json(name = "release_date")
    private String mReleaseDate;
    @Json(name = "poster_path")
    private String mPosterPath;
    @Json(name = "backdrop_path")
    private String mBackdropPath;
    private String mTitle;
    @Json(name = "vote_average")
    private double mVoteAverage;

    public Movie() {
    }

    public Movie(Parcel in) {
        mId = in.readString();
        mOverView = in.readString();
        mReleaseDate = in.readString();
        mPosterPath = in.readString();
        mBackdropPath = in.readString();
        mTitle = in.readString();
        mVoteAverage = in.readDouble();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel parcel) {
            return new Movie(parcel);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getOverView() {
        return mOverView;
    }

    public void setOverView(String overView) {
        mOverView = overView;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public double getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        mVoteAverage = voteAverage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mId);
        parcel.writeString(mOverView);
        parcel.writeString(mReleaseDate);
        parcel.writeString(mPosterPath);
        parcel.writeString(mBackdropPath);
        parcel.writeString(mTitle);
        parcel.writeDouble(mVoteAverage);
    }
}
