package com.example.hoanbk.movieguide.favorites;

import com.example.hoanbk.movieguide.DataManager.model.Movie;

import java.util.List;

/**
 * Created by hoanbk on 05/02/2018.
 */

public interface IFavoritesInteractor {
    void setFavorite(Movie movie);

    boolean isFavorite(String id);

    List<Movie> getFavorites();

    void unFavorite(String id);
}
