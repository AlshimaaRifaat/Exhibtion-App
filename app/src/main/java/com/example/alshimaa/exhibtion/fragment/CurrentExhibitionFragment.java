package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.exhibtion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentExhibitionFragment extends Fragment {


    public CurrentExhibitionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_exhibition, container, false);
    }

}
