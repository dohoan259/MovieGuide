package com.example.hoanbk.movieguide.listing;

import com.example.hoanbk.movieguide.DataManager.model.Movie;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by hoanbk on 05/02/2018.
 */

public interface IMoviesListingInteractor {
    Observable<List<Movie>> fetchMovies();
}
