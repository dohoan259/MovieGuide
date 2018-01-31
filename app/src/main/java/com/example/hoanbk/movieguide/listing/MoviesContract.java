package com.example.hoanbk.movieguide.listing;

import com.example.hoanbk.movieguide.DataManager.model.Movie;

import java.util.List;

/**
 * Created by hoanbk on 01/02/2018.
 */

public interface MoviesContract {

    interface MoviesListingView {

        void showMovies(List< Movie > movies);

        void loadingStarted();

        void loadingFailed(String errorMessage);

        void onMovieClicked(Movie movie);
    }
}
