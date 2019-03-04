package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.adapter.ExhibtorsAdapter;
import com.example.alshimaa.exhibtion.adapter.OrganizersAndServiceProvidersAdapter;
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.model.SponsorData;
import com.example.alshimaa.exhibtion.presenter.ExhibtorsPresenter;
import com.example.alshimaa.exhibtion.presenter.OrganizersAndServiceProvidersPresenter;
import com.example.alshimaa.exhibtion.view.ExhibtorsView;
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtionFragment extends Fragment implements
        YouTubePlayer.OnInitializedListener,OrganizersAndServiceProvidersView,ExhibtorsView
{
    public static final int RECOVERY_DIALOG_REQUEST=1;


    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    String Link,Title,Description,Address,ID;
    TextView title,description,address;

    RecyclerView recyclerViewOrganizers;
    OrganizersAndServiceProvidersAdapter organizersAndServiceProvidersAdapter;
    OrganizersAndServiceProvidersPresenter organizersAndServiceProvidersPresenter;

    RecyclerView recyclerViewSponsor;


    NetworkConnection networkConnection;

    TextView textToolbar;

    RecyclerView recyclerViewExhibtors;
    ExhibtorsAdapter exhibtorsAdapter;
    ExhibtorsPresenter exhibtorsPresenter;

    public DetailsExhibtionFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_exhibtion, container, false);
        init();
           networkConnection=new NetworkConnection(getContext());
        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            Link = bundle.getString( "video_link" );
            Title=bundle.getString("title");
            Description=bundle.getString("description");
            Address=bundle.getString("address");
            ID=bundle.getString("id");

            title.setText(Title);
            description.setText(Description);
            address.setText(Address);
          //  Toast.makeText(getContext(), ID, Toast.LENGTH_SHORT).show();
            textToolbar.setText(Title);

        }
        OrganizersAndServiceProviders();
        Sponsors();
        Exhibtors();
        return view;
    }

    private void Exhibtors() {
        exhibtorsPresenter=new ExhibtorsPresenter(getContext(),this);
        if(Language.isRTL()) {
            exhibtorsPresenter.getExhibtorsResult("ar", "4"); //id user
        }else {
            exhibtorsPresenter.getExhibtorsResult("en", "4");
        }
    }

    private void Sponsors() {
        organizersAndServiceProvidersPresenter=new OrganizersAndServiceProvidersPresenter(getContext(),this);
        if(Language.isRTL()) {
            organizersAndServiceProvidersPresenter.getSponsorList("ar",ID);
        }else
        {
            organizersAndServiceProvidersPresenter.getSponsorList("en",ID);
        }
    }

    private void OrganizersAndServiceProviders() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            organizersAndServiceProvidersPresenter = new OrganizersAndServiceProvidersPresenter(getContext(), this);
            if (Language.isRTL()) {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("ar", ID);
            } else {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("en", ID);
            }
        }
    }

    private void init() {
        youTubePlayerSupportFragment = (YouTubePlayerSupportFragment)
                getChildFragmentManager()
                        .findFragmentById(R.id.youtube_player_support_fragment);
        title=view.findViewById(R.id.details_exhibtion_title);
        description=view.findViewById(R.id.details_exhibtion_description);
        address=view.findViewById(R.id.details_exhibtion_address);
        recyclerViewOrganizers=view.findViewById(R.id.details_exhibtion_recycler_organizers);

        recyclerViewSponsor=view.findViewById(R.id.details_exhibtion_recycler_sponsors);
        textToolbar=view.findViewById(R.id.details_exhibtion_text_toolbar);

        recyclerViewExhibtors=view.findViewById(R.id.details_exhibtion_recycler_exhibtors);


    }


    @Override
    public void onStart() {
        super.onStart();
        getActivity(). getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {

            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            // String Url=Link.substring( Link.lastIndexOf( "=")+1  );
            youTubePlayer.loadVideo(Link);


        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
        } else {

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getYouTubePlayerProvider().initialize(YoutubeConfig.DEVELOPER_KEY, this);
    }
    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerSupportFragment)getActivity()
                .getSupportFragmentManager(). findFragmentById(R.id.youtube_player_support_fragment);
    }

    @Override
    public void showOrganizersAndServiceProvidersList(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList) {

        organizersAndServiceProvidersAdapter=new OrganizersAndServiceProvidersAdapter( getContext(),organizersAndServiceProvidersDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewOrganizers.setLayoutManager(linearLayoutManager);
        recyclerViewOrganizers.setAdapter( organizersAndServiceProvidersAdapter );
    }

    @Override
    public void showSponsorData(List<OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList) {
        organizersAndServiceProvidersAdapter=new OrganizersAndServiceProvidersAdapter( getContext(),organizersAndServiceProvidersDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSponsor.setLayoutManager(linearLayoutManager);
        recyclerViewSponsor.setAdapter( organizersAndServiceProvidersAdapter );
    }


    @Override
    public void showExhibtorsList(List<ExhibtorsData> exhibtorsDataList) {
        exhibtorsAdapter=new ExhibtorsAdapter(getContext(),exhibtorsDataList);
        recyclerViewExhibtors.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewExhibtors.setAdapter(exhibtorsAdapter);

    }

    @Override
    public void showError() {

    }
}
