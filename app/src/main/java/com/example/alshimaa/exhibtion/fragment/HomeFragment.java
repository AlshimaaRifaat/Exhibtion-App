package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.activity.RegisterNowActivity;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeJopsAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeNewsAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeServiceProviderAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeSliderAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeUnderConstructAdapter;
import com.example.alshimaa.exhibtion.adapter.NavItemServiceProvAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.model.HomeJopsData;
import com.example.alshimaa.exhibtion.model.HomeServiceProviderData;
import com.example.alshimaa.exhibtion.model.HomeSliderData;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructData;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderData;
import com.example.alshimaa.exhibtion.model.NewsData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeJopsPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeNewsPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeSliderPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeUnderConstructPresenter;
import com.example.alshimaa.exhibtion.presenter.NavItemServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.SearchHomePresenter;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionUnderConstructView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtorsView;
import com.example.alshimaa.exhibtion.view.HomeJopsView;
import com.example.alshimaa.exhibtion.view.HomeNewsView;
import com.example.alshimaa.exhibtion.view.HomeServiceProviderView;
import com.example.alshimaa.exhibtion.view.HomeSliderView;
import com.example.alshimaa.exhibtion.view.HomeUnderConstructView;
import com.example.alshimaa.exhibtion.view.NavItemServiceProvView;
import com.example.alshimaa.exhibtion.view.OnClickNavItemServiceProvView;
import com.example.alshimaa.exhibtion.view.OnclickIconHomeUnderConstructView;

import android.support.v7.app.ActionBarDrawerToggle;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeSliderView,NavItemServiceProvView
,HomeUnderConstructView,SwipeRefreshLayout.OnRefreshListener,OnclickIconHomeUnderConstructView
,HomeNewsView,DetailsExhibtionUnderConstructView,OnClickNavItemServiceProvView,HomeJopsView,CurrentExhibtionView
,DetailsExhibtionView {
    Toolbar toolbar;

    NetworkConnection networkConnection;



    RecyclerView recyclerViewHomeSlider;
    HomeSliderAdapter homeSliderAdapter;
    HomeSliderPresenter homeSliderPresenter;

    int position;
    List<HomeSliderData> sliders =new ArrayList();
    boolean end;


    /*RecyclerView recyclerViewServiceProvider;
    HomeServiceProviderAdapter homeServiceProviderAdapter;
    HomeServiceProviderPresenter homeServiceProviderPresenter;*/


    RecyclerView recyclerViewUnderConstruct;
    HomeUnderConstructAdapter homeUnderConstructAdapter;
    HomeUnderConstructPresenter homeUnderConstructPresenter;

    RecyclerView recyclerViewJops;
    HomeJopsAdapter homeJopsAdapter;
    HomeJopsPresenter homeJopsPresenter;

    RecyclerView recyclerViewCurrentExhibtion;
    CurrentExhibtionAdapter currentExhibtionAdapter;
    CurrentExhibtionPresenter currentExhibtionPresenter;

    EditText searchCurrentExhibtionEtext;


    public static EditText searchHomeExhibtionEtext;
    public static ImageView iconSearch;
    // public String KeySearchHome;
    TextView exhibitionsUnderConstructText,serviceProviderText,jopsTxt;
    SwipeRefreshLayout swipeRefreshLayout;
    Typeface customFontBold;

    RecyclerView recyclerViewNews;
    HomeNewsAdapter homeNewsAdapter;
    HomeNewsPresenter homeNewsPresenter;
    //TextView newsTxt;


    RecyclerView recyclerViewProvider;
    HomeServiceProviderAdapter homeServiceProviderAdapter;
    NavItemServiceProviderPresenter navItemServiceProviderPresenter;


    public HomeFragment() {
        // Required empty public constructor
    }

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hom, container, false);
        getActivity().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        init();
        swipRefresh();
        customFontBold = Typeface.createFromAsset( getContext().getAssets(), "DroidKufi-Bold.ttf" );
        exhibitionsUnderConstructText.setTypeface( customFontBold );
        serviceProviderText.setTypeface( customFontBold );
        jopsTxt.setTypeface(customFontBold);
        //newsTxt.setTypeface( customFontBold );

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

        UnderConstruct();
        News();
        serviceProvider();
        Jops();
        CurrentExhibtion();
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendKeySearch();

            }
        });


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

    private void Jops() {
        homeJopsPresenter=new HomeJopsPresenter(getContext(),this);
        if (Language.isRTL())
        {
            homeJopsPresenter.getHomeJopsResult("ar");
        }else
        {
            homeJopsPresenter.getHomeJopsResult("en");
        }
    }

    private void serviceProvider() {
        navItemServiceProviderPresenter=new NavItemServiceProviderPresenter(getContext(),this);
        if (Language.isRTL())
        {
            navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");
        }else
        {
            navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");
        }
    }

    private void News() {
        homeNewsPresenter=new HomeNewsPresenter(getContext(),this);
        if (Language.isRTL())
        {
            homeNewsPresenter.getHomeNewsResult("ar");
        }else
        {
            homeNewsPresenter.getHomeNewsResult("en");
        }
    }

    private void swipRefresh() {
        swipeRefreshLayout.setColorSchemeResources( android.R.color.holo_blue_dark );
        swipeRefreshLayout.setEnabled( true );
        swipeRefreshLayout.setOnRefreshListener( this );
        swipeRefreshLayout.post( new Runnable() {
            @Override
            public void run() {
                if(networkConnection.isNetworkAvailable( getContext() ))
                {
                    swipeRefreshLayout.setRefreshing( true );
                    if(Language.isRTL()) {
                        homeSliderPresenter.getHomeSliderResult("ar");
                        homeUnderConstructPresenter.getHomeUnderConstructResult("ar");
                        navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");

                    }else {
                        homeSliderPresenter.getHomeSliderResult("en");
                        homeUnderConstructPresenter.getHomeUnderConstructResult("en");
                        navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");

                    }

                }else
                {
                    Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
                }
            }
        } );
    }

    private void sendKeySearch() {
        HomeSearchResultFragment homeSearchResultFragment=new HomeSearchResultFragment();
        if( TextUtils.isEmpty(searchHomeExhibtionEtext.getText())){
            /**
             *   You can Toast a message here that the Username is Empty
             **/
            searchHomeExhibtionEtext.setError(getResources().getString(R.string.Key_search_is_required) );

        }else {
            Bundle bundle = new Bundle();
            bundle.putString("key", searchHomeExhibtionEtext.getText().toString());
            homeSearchResultFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.content_navigation,
                    homeSearchResultFragment)
                    .addToBackStack(null).commit();
        }
    }


    private void UnderConstruct() {
        homeUnderConstructPresenter=new HomeUnderConstructPresenter(getContext(),this);
        if(Language.isRTL()) {
            homeUnderConstructPresenter.getHomeUnderConstructResult("ar");
        }else {
            homeUnderConstructPresenter.getHomeUnderConstructResult("en");
        }
    }




    private void init() {

        toolbar=view.findViewById(R.id.home_toolbar);
        recyclerViewHomeSlider=view.findViewById(R.id.home_recycler_slider);
        recyclerViewProvider=view.findViewById(R.id.home_recycler_service_provider);

        recyclerViewUnderConstruct=view.findViewById(R.id.home_recycler_Exhibitions_under_construct);

        searchHomeExhibtionEtext=view.findViewById(R.id.home_edit_text_search);
        iconSearch=view.findViewById(R.id.home_icon_search);
        swipeRefreshLayout=view.findViewById(R.id.home_swip_refresh);
        exhibitionsUnderConstructText=view.findViewById(R.id.home_text_Exhibitions_under_construct);
        serviceProviderText=view.findViewById(R.id.home_text_service_provider);
        recyclerViewNews=view.findViewById(R.id.home_recycler_news);
        recyclerViewJops=view.findViewById(R.id.home_recycler_jops);
        // newsTxt=view.findViewById(R.id.home_text_news);
        jopsTxt=view.findViewById(R.id.home_text_Exhibitions_jops);
        recyclerViewCurrentExhibtion=view.findViewById(R.id.home_recycler_cur_exhibtion);

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
        swipeRefreshLayout.setRefreshing( false );


    }

    @Override
    public void onRefresh() {
        if(networkConnection.isNetworkAvailable( getContext() ))
        {
            swipeRefreshLayout.setRefreshing( true );
            if(Language.isRTL()) {
                homeSliderPresenter.getHomeSliderResult("ar");
            }else {
                homeSliderPresenter.getHomeSliderResult("en");
            }

            if(Language.isRTL()) {
                homeUnderConstructPresenter.getHomeUnderConstructResult("ar");
            }else {
                homeUnderConstructPresenter.getHomeUnderConstructResult("en");
            }

            if (Language.isRTL())
            {
                navItemServiceProviderPresenter.getNavItemServiceProviderResult("ar");
            }else
            {
                navItemServiceProviderPresenter.getNavItemServiceProviderResult("en");
            }

        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void showOnclickIconHomeUnderConstructDetails(HomeUnderConstructData homeUnderConstructData) {
        Intent intent=new Intent(getActivity(),RegisterNowActivity.class);
        //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();
        intent.putExtra("fair_id",String.valueOf(homeUnderConstructData.getId()));

        getActivity().startActivity(intent);

    }

    @Override
    public void showDetailsExhibtionUnderConstruct(HomeUnderConstructData homeUnderConstructData) {
        DetailsExhibtionFragment detailsExhibtionFragment=new DetailsExhibtionFragment();
        Bundle bundle=new Bundle(  );
        bundle.putString( "video_link",homeUnderConstructData.getYoutube());
        bundle.putString("title",homeUnderConstructData.getTitle());
        bundle.putString("description",homeUnderConstructData.getDescription());
        bundle.putString("address",homeUnderConstructData.getAddress());
        bundle.putString("id",String.valueOf(homeUnderConstructData.getId()));
        bundle.putString("user_id",homeUnderConstructData.getIdUser());
        bundle.putString("logo",homeUnderConstructData.getLogo());
        bundle.putString("visibilty","yes");
        bundle.putString("under","yes");


        detailsExhibtionFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add( R.id.content_navigation,
                detailsExhibtionFragment )
                .addToBackStack( null ).commit();
    }

    @Override
    public void showOnClickNavItemServiceProvData(NavItemServiceProviderData navItemServiceProviderData) {
        DetailsNavItemServiceProviderFragment detailsNavItemServiceProviderFragment=new DetailsNavItemServiceProviderFragment();
        Bundle bundle=new Bundle();
        bundle.putParcelable("ServiceProviderItem",navItemServiceProviderData);
        detailsNavItemServiceProviderFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,detailsNavItemServiceProviderFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void showHomeJopsList(List<HomeJopsData> homeJopsDataList) {
        homeJopsAdapter=new HomeJopsAdapter( getContext(),homeJopsDataList );
        //homeUnderConstructAdapter.onClick(this);
       // homeUnderConstructAdapter.onClickItem(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewJops.setLayoutManager(linearLayoutManager);
        recyclerViewJops.setAdapter( homeJopsAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showJopsError() {

    }

    @Override
    public void showExhibtionDetails(CurrentExhibtionData currentExhibtionData) {
        DetailsExhibtionFragment detailsExhibtionFragment=new DetailsExhibtionFragment();
        Bundle bundle=new Bundle(  );
        bundle.putString( "video_link",currentExhibtionData.getYoutube());
        bundle.putString("title",currentExhibtionData.getTitle());
        bundle.putString("description",currentExhibtionData.getDescription());
        bundle.putString("address",currentExhibtionData.getAddress());
        bundle.putString("id",String.valueOf(currentExhibtionData.getId()));
        bundle.putString("user_id",currentExhibtionData.getIdUser());
        bundle.putString("logo",currentExhibtionData.getLogo());
        bundle.putString("visibilty","yes");


        detailsExhibtionFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add( R.id.content_navigation,
                detailsExhibtionFragment )
                .addToBackStack( null ).commit();
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

   /* @Override
    public void showHomeServiceProviderList(List<HomeServiceProviderData> homeServiceProviderDataList) {
       *//* homeServiceProviderAdapter=new HomeServiceProviderAdapter( getContext(),homeServiceProviderDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewServiceProvider.setLayoutManager(linearLayoutManager);
        recyclerViewServiceProvider.setAdapter( homeServiceProviderAdapter );*//*

    }*/

    @Override
    public void showHomeUnderConstructList(List<HomeUnderConstructData> homeUnderConstructDataList) {
        homeUnderConstructAdapter=new HomeUnderConstructAdapter( getContext(),homeUnderConstructDataList );
        homeUnderConstructAdapter.onClick(this);
        homeUnderConstructAdapter.onClickItem(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewUnderConstruct.setLayoutManager(linearLayoutManager);
        recyclerViewUnderConstruct.setAdapter( homeUnderConstructAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showHomeNewsList(List<NewsData> newsDataList) {
        homeNewsAdapter=new HomeNewsAdapter( getContext(),newsDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewNews.setLayoutManager(linearLayoutManager);
        recyclerViewNews.setAdapter( homeNewsAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderDataList) {
        homeServiceProviderAdapter=new HomeServiceProviderAdapter( getContext(),navItemServiceProviderDataList );
        homeServiceProviderAdapter.onClick(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerViewProvider.setLayoutManager(gridLayoutManager);
        recyclerViewProvider.setAdapter( homeServiceProviderAdapter );
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCurrentExhibtion.setLayoutManager( linearLayoutManager);
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }



    @Override
    public void showError() {
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showSearchCurrentExhibtionList(List<CurrentExhibtionData> currentExhibtionDataList) {

    }

    @Override
    public void showSearchNavItemServiceProvList(List<NavItemServiceProviderData> navItemServiceProviderData) {

    }

    @Override
    public void showErrorSearch(String Msg) {

    }
}
