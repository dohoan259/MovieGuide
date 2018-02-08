package com.example.hoanbk.movieguide.listing.sorting;

/**
 * Created by hoanbk on 05/02/2018.
 */

public enum SortType {
    MOST_POPULAR(0), HIGHEST_RATED(1), FAVORITES(2);

    private final int vale;

    SortType(int value)
    {
        this.vale = value;
    }

    public int getVale() {
        return vale;
    }
}
