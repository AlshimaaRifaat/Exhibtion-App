package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
import com.example.alshimaa.exhibtion.adapter.HomeServiceProviderAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeSliderAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.HomeSliderData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeSliderPresenter;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.VideoLinkView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentExhibitionFragment extends Fragment implements CurrentExhibtionView
,VideoLinkView{

    Toolbar toolbar;
    NetworkConnection networkConnection;



    RecyclerView recyclerViewCurrentExhibtion;
    CurrentExhibtionAdapter currentExhibtionAdapter;
    CurrentExhibtionPresenter currentExhibtionPresenter;
    public CurrentExhibitionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_current_exhibition, container, false);

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


        CurrentExhibtion();
        return view;
    }

    private void CurrentExhibtion() {
        currentExhibtionPresenter=new CurrentExhibtionPresenter(getContext(),this);
        if (Language.isRTL()) {
            currentExhibtionPresenter.getCurrentExhibtionResult("ar");
        }else
        {
            currentExhibtionPresenter.getCurrentExhibtionResult("en");
        }

    }

    private void init() {
        toolbar=view.findViewById(R.id.current_exhibtion_toolbar);
        recyclerViewCurrentExhibtion=view.findViewById(R.id.current_exhibtion_recycler);
    }

    @Override
    public void showCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        recyclerViewCurrentExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }

    @Override
    public void showError() {

    }

    @Override
    public void sendLink(String Link) {
        if(!Link.equals( "" )){
            DetailsCurrentExhibtionFragment detailsCurrentExhibtionFragment=new DetailsCurrentExhibtionFragment();
            Bundle bundle=new Bundle(  );
            bundle.putString( "video_link",Link);
            detailsCurrentExhibtionFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().add( R.id.content_navigation,
                    detailsCurrentExhibtionFragment )
                    .addToBackStack( null ).commit();

        }
    }
}
