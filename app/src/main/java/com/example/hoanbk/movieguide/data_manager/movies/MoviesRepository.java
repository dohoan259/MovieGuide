package com.example.hoanbk.movieguide.data_manager.movies;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.example.hoanbk.movieguide.data_manager.model.Movie;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by hoanbk on 05/02/2018.
 */

public class MoviesRepository implements IMoviesRepository {

    private SharedPreferences mPreferences;

    @Inject
    public MoviesRepository(SharedPreferences preferences) {
        mPreferences = preferences;
    }

    @Override
    public void setFavorite(Movie movie) {
        Moshi moshi = new Moshi.Builder().build();
        JsonAdapter<Movie> jsonAdapter = moshi.adapter(Movie.class);
        String movieJson = jsonAdapter.toJson(movie);
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.putString(movie.getId(), movieJson);
        editor.apply();
    }

    @Override
    public boolean isFavorite(String id) {
        String movieJson = mPreferences.getString(id, null);

        return !TextUtils.isEmpty(movieJson);
    }

    @Override
    public List<Movie> getFavorites() throws IOException{
        Map<String, ?> allEntries = mPreferences.getAll();
        List<Movie> movies = new ArrayList<>(24);
        Moshi moshi = new Moshi.Builder().build();

        for(Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String movieJson = mPreferences.getString(entry.getKey(), null);

            if (!TextUtils.isEmpty(movieJson)) {
                JsonAdapter<Movie> jsonAdapter = moshi.adapter(Movie.class);

                try {
                    Movie movie = jsonAdapter.fromJson(movieJson);
                    movies.add(movie);
                } catch(IOException e) {

                }
            } else {

            }
        }
        return movies;
    }

    @Override
    public void unFavorite(String id) {
        SharedPreferences.Editor editor = mPreferences.edit();
        editor.remove(id);
        editor.apply();
    }
}
