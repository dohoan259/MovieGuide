package com.example.hoanbk.movieguide.favorites;

import com.example.hoanbk.movieguide.DataManager.model.Movie;

import java.util.List;

/**
 * Created by hoanbk on 05/02/2018.
 */

public class FavoritesInteractor implements IFavoritesInteractor{



    @Override
    public void setFavorite(Movie movie) {

    }

    @Override
    public boolean isFavorite(String id) {
        return false;
    }

    @Override
    public List<Movie> getFavorites() {
        return null;
    }

    @Override
    public void unFavorite(String id) {

    }
}
