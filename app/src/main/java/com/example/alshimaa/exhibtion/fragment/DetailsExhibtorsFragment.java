package com.example.alshimaa.exhibtion.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtorsFragment extends Fragment implements YouTubePlayer.OnInitializedListener {

    String Link,Title,Address,ID,Phone,Email,WebsiteLink;
    TextView title,address,phone,email,websiteLink;

    NetworkConnection networkConnection;

    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    TextView textToolbar;

    public DetailsExhibtorsFragment() {
        // Required empty public constructor
    }

View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_exhibtors, container, false);
        init();
        networkConnection=new NetworkConnection(getContext());
        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            Link = bundle.getString( "video_link_exhibtor" );
            Title=bundle.getString("title_exhibtor");
            Address=bundle.getString("address_exhibtor");
            ID=bundle.getString("id");
            Phone=bundle.getString("phone_exhibtor");
            Email=bundle.getString("email_exhibtor");
            WebsiteLink=bundle.getString("website_link");

            title.setText(Title);
            address.setText(Address);
            phone.setText(Phone);
            email.setText(Email);
            websiteLink.setText(WebsiteLink);

            textToolbar.setText(Title);
            //  Toast.makeText(getContext(), ID, Toast.LENGTH_SHORT).show();

        }

        return view;
    }

    private void init() {
        title=view.findViewById(R.id.details_exhibtors_title);
        address=view.findViewById(R.id.details_exhibtors_address);
        textToolbar=view.findViewById(R.id.details_exhibtors_text_toolbar);
        youTubePlayerSupportFragment = (YouTubePlayerSupportFragment)
                getChildFragmentManager()
                        .findFragmentById(R.id.details_exhibtors_youtube_player_support_fragment);
    phone=view.findViewById(R.id.details_exhibtors_text_phone);
    email=view.findViewById(R.id.details_exhibtors_text_email);
    websiteLink=view.findViewById(R.id.details_exhibtors_text_website);
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
             String url=Link.substring( Link.lastIndexOf( "=")+1  );
            youTubePlayer.loadVideo(url);


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
                .getSupportFragmentManager(). findFragmentById(R.id.details_exhibtors_youtube_player_support_fragment);
    }
}

