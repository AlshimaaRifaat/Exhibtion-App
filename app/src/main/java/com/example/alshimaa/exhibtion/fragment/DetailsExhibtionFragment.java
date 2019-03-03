package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.adapter.HomeServiceProviderAdapter;
import com.example.alshimaa.exhibtion.adapter.OrganizersAndServiceProvidersAdapter;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.presenter.HomeServiceProviderPresenter;
import com.example.alshimaa.exhibtion.presenter.OrganizersAndServiceProvidersPresenter;
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtionFragment extends Fragment implements
        YouTubePlayer.OnInitializedListener,OrganizersAndServiceProvidersView{
    public static final int RECOVERY_DIALOG_REQUEST=1;


    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    String Link,Title,Description,Address;
    TextView title,description,address;

    RecyclerView recyclerViewOrganizers;
    OrganizersAndServiceProvidersAdapter organizersAndServiceProvidersAdapter;
    OrganizersAndServiceProvidersPresenter organizersAndServiceProvidersPresenter;

    NetworkConnection networkConnection;
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

            title.setText(Title);
            description.setText(Description);
            address.setText(Address);

        }
        OrganizersAndServiceProviders();
        return view;
    }

    private void OrganizersAndServiceProviders() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            organizersAndServiceProvidersPresenter = new OrganizersAndServiceProvidersPresenter(getContext(), this);
            if (Language.isRTL()) {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("ar", "1");
            } else {
                organizersAndServiceProvidersPresenter.getOrganizersAndServiceProvidersResult("en", "1");
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
    public void showError() {

    }
}
