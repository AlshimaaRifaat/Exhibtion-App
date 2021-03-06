package com.exhibtion.fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeJopsAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.HomeJopsData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeJopsPresenter;
import com.example.alshimaa.exhibtion.view.CurrentExhibtionView;
import com.example.alshimaa.exhibtion.view.DetailsExhibtionView;
import com.example.alshimaa.exhibtion.view.HomeJopsView;*/

import com.exhibtion.Language;
import com.exhibtion.NetworkConnection;
import com.exhibtion.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentExhibitionFragment extends Fragment implements com.exhibtion.view.CurrentExhibtionView
, com.exhibtion.view.DetailsExhibtionView, com.exhibtion.view.HomeJopsView {

    Toolbar toolbar;
    NetworkConnection networkConnection;



    RecyclerView recyclerViewCurrentExhibtion;
    com.exhibtion.adapter.CurrentExhibtionAdapter currentExhibtionAdapter;
    com.exhibtion.presenter.CurrentExhibtionPresenter currentExhibtionPresenter;

    EditText searchCurrentExhibtionEtext;
    ImageView iconSearch;

    com.exhibtion.presenter.HomeJopsPresenter homeJopsPresenter;
    RecyclerView recyclerViewJops;
    com.exhibtion.adapter.HomeJopsAdapter homeJopsAdapter;
    TextView jopsTxt;

    Typeface customFontBold;
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
        customFontBold = Typeface.createFromAsset( getContext().getAssets(), "DroidKufi-Bold.ttf" );
        jopsTxt.setTypeface(customFontBold);

        com.exhibtion.activity.NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), com.exhibtion.activity.NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);



        com.exhibtion.activity.NavigationActivity.drawer.addDrawerListener(com.exhibtion.activity.NavigationActivity.toggle);
        com.exhibtion.activity.NavigationActivity.toggle.syncState();

        com.exhibtion.activity.NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav  );

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (com.exhibtion.activity.NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    com.exhibtion.activity.NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    com.exhibtion.activity.NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        com.exhibtion.activity.NavigationActivity.toggle = new ActionBarDrawerToggle(
                getActivity(), com.exhibtion.activity.NavigationActivity.drawer, toolbar,R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        com.exhibtion.activity.NavigationActivity.drawer.addDrawerListener(com.exhibtion.activity.NavigationActivity.toggle);
        com.exhibtion.activity.NavigationActivity.toggle.syncState();
        com.exhibtion.activity.NavigationActivity.toggle.setDrawerIndicatorEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_humburger_nav);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (com.exhibtion.activity.NavigationActivity.drawer.isDrawerOpen(GravityCompat.START)) {
                    com.exhibtion.activity.NavigationActivity.drawer.closeDrawer(GravityCompat.START);
                } else {
                    com.exhibtion.activity.NavigationActivity.drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        networkConnection=new NetworkConnection( getContext() );


        CurrentExhibtion();
        Jops();
        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });


        return view;
    }

    private void Jops() {
        homeJopsPresenter=new com.exhibtion.presenter.HomeJopsPresenter(getContext(),this);
        if (Language.isRTL())
        {
            homeJopsPresenter.getHomeJopsResult("ar");
        }else
        {
            homeJopsPresenter.getHomeJopsResult("en");
        }
    }

    private void performSearch() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            currentExhibtionPresenter = new com.exhibtion.presenter.CurrentExhibtionPresenter(getContext(), this);
            if( TextUtils.isEmpty(searchCurrentExhibtionEtext.getText())){
                /**
                 *   You can Toast a message here that the Username is Empty
                 **/

                searchCurrentExhibtionEtext.setError(getResources().getString(R.string.Key_search_is_required) );

            } else {
                        if (Language.isRTL()) {
                            currentExhibtionPresenter.getSearchCurrentExhibtionResult("ar", searchCurrentExhibtionEtext.getText().toString());
                        } else {
                            currentExhibtionPresenter.getSearchCurrentExhibtionResult("en", searchCurrentExhibtionEtext.getText().toString());
                        }
                }

        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }

    }

    private void CurrentExhibtion() {
        currentExhibtionPresenter=new com.exhibtion.presenter.CurrentExhibtionPresenter(getContext(),this);
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
        searchCurrentExhibtionEtext=view.findViewById(R.id.current_exhibtion_edit_text_search);
        iconSearch=view.findViewById(R.id.current_exhibtion_icon_search);
        recyclerViewJops=view.findViewById(R.id.current_exhibtion_recycler_jops);
        jopsTxt=view.findViewById(R.id.current_exhibtion_text_jops);
    }

    @Override
    public void showCurrentExhibtionList(List<com.exhibtion.model.CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new com.exhibtion.adapter.CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        recyclerViewCurrentExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSearchCurrentExhibtionList(List<com.exhibtion.model.CurrentExhibtionData> currentExhibtionDataList) {
        currentExhibtionAdapter=new com.exhibtion.adapter.CurrentExhibtionAdapter( getContext(),currentExhibtionDataList );
        currentExhibtionAdapter.onClick(this);
        recyclerViewCurrentExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewCurrentExhibtion.setAdapter( currentExhibtionAdapter );
    }

    @Override
    public void showErrorSearch(String Msg) {
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showExhibtionDetails(com.exhibtion.model.CurrentExhibtionData currentExhibtionData) {

            com.exhibtion.fragment.DetailsExhibtionFragment detailsExhibtionFragment=new com.exhibtion.fragment.DetailsExhibtionFragment();
            Bundle bundle=new Bundle(  );
            bundle.putString( "video_link",currentExhibtionData.getYoutube());
            bundle.putString("title",currentExhibtionData.getTitle());
            bundle.putString("description",currentExhibtionData.getDescription());
            bundle.putString("address",currentExhibtionData.getAddress());
            bundle.putString("id",String.valueOf(currentExhibtionData.getId()));
            bundle.putString("user_id",currentExhibtionData.getIdUser());
            bundle.putString("logo",currentExhibtionData.getLogo());
            bundle.putString("link_360",currentExhibtionData.getLink360());
            bundle.putString("hole1",currentExhibtionData.getHole1());
            bundle.putString("hole2",currentExhibtionData.getHole2());
            bundle.putString("hole3",currentExhibtionData.getHole3());
            bundle.putString("hole4",currentExhibtionData.getHole4());
            bundle.putString("imgg",currentExhibtionData.getImg());
            bundle.putString("visibilty","yes");
            bundle.putString("img_or_video","current");

            detailsExhibtionFragment.setArguments(bundle);

            getFragmentManager().beginTransaction().add( R.id.content_navigation,
                    detailsExhibtionFragment )
                    .addToBackStack( null ).commit();



    }

    @Override
    public void showHomeJopsList(List<com.exhibtion.model.HomeJopsData> homeJopsDataList) {
        homeJopsAdapter=new com.exhibtion.adapter.HomeJopsAdapter( getContext(),homeJopsDataList );
        //homeUnderConstructAdapter.onClick(this);
        // homeUnderConstructAdapter.onClickItem(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewJops.setLayoutManager(linearLayoutManager);
        recyclerViewJops.setAdapter( homeJopsAdapter );

    }

    @Override
    public void showJopsError() {

    }
}
