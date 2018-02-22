package com.example.hoanbk.movieguide.listing;

import com.example.hoanbk.movieguide.data_manager.model.Movie;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hoanbk on 02/02/2018.
 */

public class MoviesListingPresenter implements MoviesContract.IMoviesListingPresenter{

    private MoviesContract.IMoviesListingView mView;
    private IMoviesListingInteractor mMoviesInteractor;
    private Disposable mFetchSubscription;

    public MoviesListingPresenter(IMoviesListingInteractor moviesInteractor) {
        mMoviesInteractor = moviesInteractor;
    }

    @Override
    public void displayMovies() {
        showLoading();
        mFetchSubscription = mMoviesInteractor.fetchMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onMoviesFetchSuccess, this::onMoviesFetchFailed);
    }

    private void showLoading() {
        if (isViewAttached()) {
            mView.loadingStarted();
        }
    }

    private boolean isViewAttached() {
        return mView != null;
    }


    @Override
    public void setView(MoviesContract.IMoviesListingView view) {
        mView = view;
        displayMovies();
    }

    @Override
    public void destroy() {
        mView = null;
        // unsubscribe subscription
    }

    private void onMoviesFetchSuccess(List<Movie> movies) {
        if (isViewAttached()) {
            mView.showMovies(movies);
        }
    }

    private void onMoviesFetchFailed(Throwable e) {
        mView.loadingFailed(e.getMessage());
    }
}
