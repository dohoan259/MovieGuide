package com.example.hoanbk.movieguide.favorites;

import com.example.hoanbk.movieguide.data_manager.movies.IMoviesRepository;
import com.example.hoanbk.movieguide.di.AppModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hoanbk on 22/02/2018.
 */

@Module(includes = AppModule.class)
public class FavoritesModul {

    @Provides
    @Singleton
    IFavoritesInteractor provideFavoritesInteractor(IMoviesRepository moviesRepository)
    {
        return new FavoritesInteractor(moviesRepository);
    }
}
