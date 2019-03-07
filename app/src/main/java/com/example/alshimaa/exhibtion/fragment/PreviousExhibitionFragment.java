package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.PreviousExhibtionAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.PreviousExhibtionPresenter;
import com.example.alshimaa.exhibtion.view.PreviousExhibtionView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousExhibitionFragment extends Fragment implements PreviousExhibtionView{

    Toolbar toolbar;
    NetworkConnection networkConnection;



    RecyclerView recyclerViewPreviousExhibtion;
    PreviousExhibtionAdapter previousExhibtionAdapter;
    PreviousExhibtionPresenter previousExhibtionPresenter;
    public PreviousExhibitionFragment() {
        // Required empty public constructor
    }

  View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_previous_exhibition, container, false);
        init();


        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);



        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();

        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav  );

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        NavigationActivity.drawer.addDrawerListener(NavigationActivity.toggle);
        NavigationActivity.toggle.syncState();
        NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        networkConnection=new NetworkConnection( getContext() );

        PreviousExhibtion();
        return view;
    }

    private void PreviousExhibtion() {
        previousExhibtionPresenter=new PreviousExhibtionPresenter(getContext(),this);
        if(Language.isRTL())
        {
            previousExhibtionPresenter.getPreviousExhibtionResult("ar");
        }else {
            previousExhibtionPresenter.getPreviousExhibtionResult("en");
        }
    }

    private void init() {
        toolbar=view.findViewById(R.id.previous_exhibtion_toolbar);
        recyclerViewPreviousExhibtion=view.findViewById(R.id.previous_exhibtion_recycler);

    }

    @Override
    public void showPreviousExhibtionList(List<PreviousExhibtionData> previousExhibtionDataList) {
        previousExhibtionAdapter=new PreviousExhibtionAdapter( getContext(),previousExhibtionDataList );
        //homeProductAdapter.onClick(this);
        recyclerViewPreviousExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewPreviousExhibtion.setAdapter( previousExhibtionAdapter );
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSearchPreviousExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {

    }

    @Override
    public void showErrorSearchPrevious(String Msg) {

    }
}
