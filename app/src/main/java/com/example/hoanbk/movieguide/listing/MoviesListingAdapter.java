package com.example.hoanbk.movieguide.listing;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoanbk.movieguide.DataManager.model.Movie;
import com.example.hoanbk.movieguide.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by hoanbk on 01/02/2018.
 */

class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context mContext;
    private MoviesContract.MoviesListingView mView;

    public MoviesListingAdapter(List<Movie> movies, MoviesContract.MoviesListingView view) {
        mMovies = movies;
        mView = view;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.movie_grid_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Movie mMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
