package com.example.hoanbk.movieguide.listing;

import com.example.hoanbk.movieguide.data_manager.model.Movie;

import java.util.List;

/**
 * Created by hoanbk on 01/02/2018.
 */

public interface MoviesContract {

    interface IMoviesListingView
    {

        void showMovies(List< Movie > movies);

        void loadingStarted();

        void loadingFailed(String errorMessage);

        void onMovieClicked(Movie movie);
    }

    interface IMoviesListingPresenter
    {

        void displayMovies();

        void setView(IMoviesListingView view);

        void destroy();
    }
}
