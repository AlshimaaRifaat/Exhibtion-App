package com.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/*import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.PreviousExhibtionAdapter;
import com.example.alshimaa.exhibtion.model.CurrentExhibtionData;
import com.example.alshimaa.exhibtion.model.PreviousExhibtionData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.PreviousExhibtionPresenter;
import com.example.alshimaa.exhibtion.view.DetailsPreviousExhibtion;
import com.example.alshimaa.exhibtion.view.PreviousExhibtionView;*/

import com.exhibtion.Language;
import com.exhibtion.NetworkConnection;
import com.exhibtion.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreviousExhibitionFragment extends Fragment implements com.exhibtion.view.PreviousExhibtionView
, com.exhibtion.view.DetailsPreviousExhibtion {

    Toolbar toolbar;
    NetworkConnection networkConnection;



    RecyclerView recyclerViewPreviousExhibtion;
    com.exhibtion.adapter.PreviousExhibtionAdapter previousExhibtionAdapter;
    com.exhibtion.presenter.PreviousExhibtionPresenter previousExhibtionPresenter;

    EditText searchPreviousExhibtionEtext;
    ImageView iconSearch;
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

        PreviousExhibtion();

        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
        return view;
    }

    private void performSearch() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            previousExhibtionPresenter = new com.exhibtion.presenter.PreviousExhibtionPresenter(getContext(), this);
            if( TextUtils.isEmpty(searchPreviousExhibtionEtext.getText())){
                /**
                 *   You can Toast a message here that the Username is Empty
                 **/

                searchPreviousExhibtionEtext.setError(getResources().getString(R.string.Key_search_is_required) );

            } else {
                if (Language.isRTL()) {
                    previousExhibtionPresenter.getSearchPreviousExhibtionResult("ar", searchPreviousExhibtionEtext.getText().toString());
                } else {
                    previousExhibtionPresenter.getSearchPreviousExhibtionResult("en", searchPreviousExhibtionEtext.getText().toString());
                }
            }

        }else
        {
            Toast.makeText(getContext(), getResources().getString(R.string.checkNetworkConnection), Toast.LENGTH_SHORT).show();
        }
    }

    private void PreviousExhibtion() {
        previousExhibtionPresenter=new com.exhibtion.presenter.PreviousExhibtionPresenter(getContext(),this);
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
        searchPreviousExhibtionEtext=view.findViewById(R.id.previous_exhibtion_edit_text_search);
        iconSearch=view.findViewById(R.id.previous_exhibtion_icon_search);

    }

    @Override
    public void showPreviousExhibtionList(List<com.exhibtion.model.PreviousExhibtionData> previousExhibtionDataList) {
        previousExhibtionAdapter=new com.exhibtion.adapter.PreviousExhibtionAdapter( getContext(),previousExhibtionDataList );
        previousExhibtionAdapter.onClick(this);
        recyclerViewPreviousExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewPreviousExhibtion.setAdapter( previousExhibtionAdapter );
    }

    @Override
    public void showError() {

    }

    @Override
    public void showSearchPreviousExhibtionList(List<com.exhibtion.model.PreviousExhibtionData> previousExhibtionDataList) {
        previousExhibtionAdapter=new com.exhibtion.adapter.PreviousExhibtionAdapter( getContext(),previousExhibtionDataList );
        previousExhibtionAdapter.onClick(this);
        recyclerViewPreviousExhibtion.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewPreviousExhibtion.setAdapter( previousExhibtionAdapter );
    }


    @Override
    public void showErrorSearchPrevious(String Msg) {
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showExhibtionDetails(com.exhibtion.model.PreviousExhibtionData previousExhibtionData) {
        com.exhibtion.fragment.DetailsExhibtionFragment detailsExhibtionFragment=new com.exhibtion.fragment.DetailsExhibtionFragment();
        Bundle bundle=new Bundle(  );
        bundle.putString( "video_link",previousExhibtionData.isYoutube());
        bundle.putString("title",previousExhibtionData.getTitle());
        bundle.putString("description",previousExhibtionData.getDescription());
        bundle.putString("address",previousExhibtionData.getAddress());
        bundle.putString("id",String.valueOf(previousExhibtionData.getId()));
        bundle.putString("user_id",previousExhibtionData.getIdUser());
        bundle.putString("imgg",previousExhibtionData.getImg());
        bundle.putString("link_360",previousExhibtionData.getLink360());
        bundle.putString("visibilty","no");
        bundle.putString("img_or_video","previous");
        detailsExhibtionFragment.setArguments(bundle);
        getFragmentManager().beginTransaction().add( R.id.content_navigation,
                detailsExhibtionFragment )
                .addToBackStack( null ).commit();

    }
}
