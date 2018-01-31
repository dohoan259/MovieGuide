package com.example.hoanbk.movieguide.listing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.hoanbk.movieguide.R;

public class MoviesListingActivity extends AppCompatActivity {

    public static final String DETAILS_FRAGMENT = "DetailsFragment";
    private boolean twoPaneMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

//        if (findViewById(R.id.movie_details_container) != null) {
//            twoPaneMode = true;
//
//            if (savedInstanceState == null) {
//                getSupportFragmentManager().beginTransaction()
//                        .remove(R.id.movie_details_container, new Movie())
//            }
//        }
    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.movie_guide);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }
}
