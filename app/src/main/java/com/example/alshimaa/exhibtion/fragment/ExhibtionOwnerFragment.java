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
public class ExhibtionOwnerFragment extends Fragment {


    public ExhibtionOwnerFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_exhibtion_owner, container, false);
        init();
        return view;
    }

    private void init() {

    }

}
