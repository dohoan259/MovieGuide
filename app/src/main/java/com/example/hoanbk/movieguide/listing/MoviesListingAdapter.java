package com.example.hoanbk.movieguide.listing;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.hoanbk.movieguide.data_manager.Api;
import com.example.hoanbk.movieguide.data_manager.model.Movie;
import com.example.hoanbk.movieguide.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by hoanbk on 01/02/2018.
 */

class MoviesListingAdapter extends RecyclerView.Adapter<MoviesListingAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context mContext;
    private MoviesContract.IMoviesListingView mView;

    public MoviesListingAdapter(List<Movie> movies, MoviesContract.IMoviesListingView view) {
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
        holder.onBind(mMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void replaceData(List<Movie> movies) {
        mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.movie_poster)
        ImageView mPoster;
        @BindView(R.id.title_background)
        View mTitleBackground;
        @BindView(R.id.movie_name)
        TextView mName;

        private Movie mMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(Movie movie) {
            mMovie = movie;
            mName.setText(movie.getTitle());

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .priority(Priority.HIGH);

            Glide.with(mContext)
                    .asBitmap()
                    .load(Api.getPosterPath(movie.getPosterPath()))
                    .apply(options)
                    .into(new BitmapImageViewTarget(mPoster) {
                        @Override
                        public void onResourceReady(Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                            super.onResourceReady(resource, transition);
                            Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                                @Override
                                public void onGenerated(Palette palette) {
                                    mTitleBackground.setBackgroundColor(palette.getVibrantColor(mContext
                                    .getResources().getColor(R.color.black_translucent_60)));
                                }
                            });
                        }
                    });
        }

        @Override
        public void onClick(View view) {
            MoviesListingAdapter.this.mView.onMovieClicked(mMovie);
        }
    }
}
