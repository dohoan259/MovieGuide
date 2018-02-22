package com.example.hoanbk.movieguide.favorites;

import com.example.hoanbk.movieguide.data_manager.model.Movie;
import com.example.hoanbk.movieguide.data_manager.movies.IMoviesRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoanbk on 05/02/2018.
 */

public class FavoritesInteractor implements IFavoritesInteractor{

    private IMoviesRepository mMoviesRepository;

    public FavoritesInteractor(IMoviesRepository moviesRepository) {
        mMoviesRepository = moviesRepository;
    }

    @Override
    public void setFavorite(Movie movie) {
        mMoviesRepository.setFavorite(movie);
    }

    @Override
    public boolean isFavorite(String id) {
        return mMoviesRepository.isFavorite(id);
    }

    @Override
    public List<Movie> getFavorites() {
        try{
            return mMoviesRepository.getFavorites();
        } catch (IOException e) {
            return new ArrayList<>(0);
        }
    }

    @Override
    public void unFavorite(String id) {
        mMoviesRepository.unFavorite(id);
    }
}
