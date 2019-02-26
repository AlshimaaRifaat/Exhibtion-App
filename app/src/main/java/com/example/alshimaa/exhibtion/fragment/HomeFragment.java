package com.example.alshimaa.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
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
import com.example.alshimaa.exhibtion.adapter.HomeServiceProviderAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeSliderAdapter;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;
import com.example.alshimaa.exhibtion.model.HomeSliderData;
import com.example.alshimaa.exhibtion.presenter.HomeServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeSliderPresenter;
import com.example.alshimaa.exhibtion.view.HomeServiceProviderView;
import com.example.alshimaa.exhibtion.view.HomeSliderView;

import android.support.v7.app.ActionBarDrawerToggle;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeSliderView,HomeServiceProviderView{
    Toolbar toolbar;

    NetworkConnection networkConnection;



    RecyclerView recyclerViewHomeSlider;
    HomeSliderAdapter homeSliderAdapter;
    HomeSliderPresenter homeSliderPresenter;

    int position;
    List<HomeSliderData> sliders =new ArrayList();
    boolean end;


    RecyclerView recyclerViewServiceProvider;
    HomeServiceProviderAdapter homeServiceProviderAdapter;
    HomeServiceProviderPresenter homeServiceProviderPresenter;
    public HomeFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hom, container, false);
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

        Slider();
        ServiceProvider();
        return view;
    }

    private void ServiceProvider() {
        homeServiceProviderPresenter=new HomeServiceProviderPresenter(getContext(),this);
        if(Language.isRTL()) {
            homeServiceProviderPresenter.getHomeServiceResult("ar");
        }else
        {
            homeServiceProviderPresenter.getHomeServiceResult("en");
        }
    }


    private void init() {
       toolbar=view.findViewById(R.id.home_toolbar);
       recyclerViewHomeSlider=view.findViewById(R.id.home_recycler_slider);
       recyclerViewServiceProvider=view.findViewById(R.id.home_recycler_service_provider);
    }
    private void Slider() {
        homeSliderPresenter=new HomeSliderPresenter(getContext(),this);
        if(Language.isRTL()) {
            homeSliderPresenter.getHomeSliderResult("ar");
        }else {
            homeSliderPresenter.getHomeSliderResult("en");
        }
    }

    @Override
    public void showHomeSliderResult(List<HomeSliderData> homeSliderDataList) {
        sliders=homeSliderDataList;
        homeSliderAdapter=new HomeSliderAdapter( getContext(),homeSliderDataList );
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager( getContext() );
        linearLayoutManager.setOrientation( LinearLayoutManager.HORIZONTAL );
        recyclerViewHomeSlider.setLayoutManager( linearLayoutManager );
        recyclerViewHomeSlider.setAdapter( homeSliderAdapter );

        if(sliders.size()>1) {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate( new AutoScrollTask(), 4000, 7000 );
        }
       // swipeRefreshLayout.setRefreshing( false );


    }
    private class AutoScrollTask extends TimerTask {
        @Override
        public void run() {
            try {
                if (position == sliders.size() - 1) {
                    end = true;
                } else if (position == 0) {
                    end = false;
                }

                if (!end) {
                    position++;
                } else {
                    position--;
                }
                recyclerViewHomeSlider.smoothScrollToPosition(position);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void showHomeServiceProviderList(List<HomeServiceProviderData> homeServiceProviderDataList) {
        homeServiceProviderAdapter=new HomeServiceProviderAdapter( getContext(),homeServiceProviderDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewServiceProvider.setLayoutManager(linearLayoutManager);
        recyclerViewServiceProvider.setAdapter( homeServiceProviderAdapter );
    }

    @Override
    public void showError() {

    }
}
