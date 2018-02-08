package com.example.hoanbk.movieguide.listing.sorting;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hoanbk.movieguide.R;
import com.example.hoanbk.movieguide.listing.MoviesContract;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SortingDialogFragment extends DialogFragment {


    private Unbinder mUnbinder;

    public SortingDialogFragment() {
        // Required empty public constructor
    }

    public static SortingDialogFragment newInstance(MoviesContract.IMoviesListingPresenter moviesListingPresenter)
    {
        Bundle args = new Bundle();
        SortingDialogFragment fragment = new SortingDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        // getComponent

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater =
                (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.sorting_options, null);
        mUnbinder = ButterKnife.bind(this, dialogView);
        initView();

        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(dialogView);
        dialog.setTitle(R.string.sort_by);
        dialog.show();
        return dialog;
    }

    private void initView() {
    }
}
