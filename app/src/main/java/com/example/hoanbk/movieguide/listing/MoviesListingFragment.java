package com.example.hoanbk.movieguide.listing;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoanbk.movieguide.data_manager.model.Movie;
import com.example.hoanbk.movieguide.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MoviesListingFragment.Callback} interface
 * to handle interaction events.
 */
public class MoviesListingFragment extends Fragment
        implements MoviesContract.IMoviesListingView {

    @BindView(R.id.movies_listing)
    RecyclerView mMoviesListing;

    private List<Movie> mMovies = new ArrayList<>(20);
    private Callback mCallback;
    private Unbinder mUnbinder;
    private RecyclerView.Adapter mAdapter;

    public MoviesListingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Callback) {
            mCallback = (Callback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        // init view for two pane mode
        initLayoutReferences();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // set View for presenter
    }

    private void initLayoutReferences() {
        mMoviesListing.setHasFixedSize(true);

        int columns;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columns = 2;
        } else {
            columns = getResources().getInteger(R.integer.no_of_columns);
        }
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), columns);

        mMoviesListing.setLayoutManager(layoutManager);
        mAdapter = new MoviesListingAdapter(mMovies, this);
        mMoviesListing.setAdapter(mAdapter);

    }

    @Override
    public void showMovies(List<Movie> movies) {

    }

    @Override
    public void loadingStarted() {

    }

    @Override
    public void loadingFailed(String errorMessage) {

    }

    @Override
    public void onMovieClicked(Movie movie) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // destroy presenter
        mUnbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

    public interface Callback {


    }
}
