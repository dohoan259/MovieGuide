package com.example.hoanbk.movieguide.data_manager.movies;

import com.example.hoanbk.movieguide.data_manager.model.Movie;

import java.io.IOException;
import java.util.List;

/**
 * Created by hoanbk on 05/02/2018.
 */

public interface IMoviesRepository {

    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites() throws IOException;

    void unFavorite(String id);
}
