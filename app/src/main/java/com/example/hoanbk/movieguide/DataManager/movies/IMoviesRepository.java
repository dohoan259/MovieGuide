package com.example.hoanbk.movieguide.DataManager.movies;

import com.example.hoanbk.movieguide.DataManager.model.Movie;

import java.util.List;

/**
 * Created by hoanbk on 05/02/2018.
 */

public interface IMoviesRepository {

    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    public List<Movie> getFavorites();

    public void unFavorite(String id);
}
