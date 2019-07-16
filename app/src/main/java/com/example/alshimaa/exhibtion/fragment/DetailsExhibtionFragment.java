package com.exhibtion.fragment;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
/*import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.activity.LinkOfExhibtionActivity;
import com.example.alshimaa.exhibtion.activity.RegisterActivity;
import com.example.alshimaa.exhibtion.activity.RegisterInExhibtionActivity;
import com.example.alshimaa.exhibtion.activity.RegisterNowActivity;
import com.example.alshimaa.exhibtion.adapter.ExhibtorsAdapter;
import com.example.alshimaa.exhibtion.adapter.HallFourAdapter;
import com.example.alshimaa.exhibtion.adapter.HallOneAdapter;
import com.example.alshimaa.exhibtion.adapter.HallThreeAdapter;
import com.example.alshimaa.exhibtion.adapter.HallTwoAdapter;
import com.example.alshimaa.exhibtion.adapter.OrganizersAndServiceProvidersAdapter;
import com.example.alshimaa.exhibtion.adapter.SponsorAdapter;
import com.example.alshimaa.exhibtion.model.ExhibtorsData;
import com.example.alshimaa.exhibtion.model.HallFourData;
import com.example.alshimaa.exhibtion.model.HallOneData;
import com.example.alshimaa.exhibtion.model.HallThreeData;
import com.example.alshimaa.exhibtion.model.HallTwoData;
import com.example.alshimaa.exhibtion.model.OrganizersAndServiceProvidersData;
import com.example.alshimaa.exhibtion.model.SponsorData;
import com.example.alshimaa.exhibtion.presenter.ExhibtorsPresenter;
import com.example.alshimaa.exhibtion.presenter.HallFourPresenter;
import com.example.alshimaa.exhibtion.presenter.HallOnePresenter;
import com.example.alshimaa.exhibtion.presenter.HallThreePresenter;
import com.example.alshimaa.exhibtion.presenter.HallTwoPresenter;
import com.example.alshimaa.exhibtion.presenter.OrganizersAndServiceProvidersPresenter;
import com.example.alshimaa.exhibtion.presenter.SponsorPresenter;
import com.example.alshimaa.exhibtion.view.DetailsExhibtorsView;
import com.example.alshimaa.exhibtion.view.ExhibtorsView;
import com.example.alshimaa.exhibtion.view.HallOneView;
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;*/
import com.exhibtion.Language;
import com.exhibtion.NetworkConnection;
import com.exhibtion.R;
import com.exhibtion.YoutubeConfig;
import com.exhibtion.model.ExhibtorDetailsData;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtionFragment extends Fragment implements
        YouTubePlayer.OnInitializedListener, com.exhibtion.view.OrganizersAndServiceProvidersView
        , com.exhibtion.view.ExhibtorsView, com.exhibtion.view.DetailsExhibtorsView, com.exhibtion.view.HallOneView
{
    com.exhibtion.presenter.HallOnePresenter hallOnePresenter;
    Spinner hallOneSpinner;
    Integer HallOneModelID;
    String HallOneModel;
    com.exhibtion.adapter.HallOneAdapter hallOneAdapter;


    com.exhibtion.presenter.HallTwoPresenter hallTwoPresenter;
    Spinner hallTwoSpinner;
    Integer HallTwoModelID;
    String HallTwoModel;
    com.exhibtion.adapter.HallTwoAdapter hallTwoAdapter;

    com.exhibtion.presenter.HallThreePresenter hallThreePresenter;
    Spinner hallThreeSpinner;
    Integer HallThreeModelID;
    String HallThreeModel;
    com.exhibtion.adapter.HallThreeAdapter hallThreeAdapter;

    com.exhibtion.presenter.HallFourPresenter hallFourPresenter;
    Spinner hallFourSpinner;
    Integer HallFourModelID;
    String HallFourModel;
    com.exhibtion.adapter.HallFourAdapter hallFourAdapter;


    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
    public static String Link,Title,Description,Address,ID,UserId,Img,Visiblity,Visitor,FromCur
            ,Under,Img_or_video,UserId_underConstruct,Hole1,Hole2,Hole3,Hole4;
    TextView title,description,address;
    ImageView imageView;

    RecyclerView recyclerViewOrganizers;
    com.exhibtion.adapter.OrganizersAndServiceProvidersAdapter organizersAndServiceProvidersAdapter;
    com.exhibtion.presenter.OrganizersAndServiceProvidersPresenter organizersAndServiceProvidersPresenter;

    com.exhibtion.presenter.SponsorPresenter sponsorPresenter;

    RecyclerView recyclerViewSponsor;


    NetworkConnection networkConnection;

    TextView textToolbar;

    RecyclerView recyclerViewExhibtors;
    com.exhibtion.adapter.ExhibtorsAdapter exhibtorsAdapter;
    com.exhibtion.presenter.ExhibtorsPresenter exhibtorsPresenter;
    String Link360,ID_Exhibtor;
    public static Button registerNowBtn,link360Btn;

    public static Button registerAsExhibtor;

    Intent intent;

    // details_exhibtion_card_diagram
    Button btnExhibtionDiagram;
    com.exhibtion.adapter.SponsorAdapter sponsorAdapter;

    public static String RegisterFromCurExhib,FromUnder;
    com.exhibtion.presenter.ExhibtorDetailsPresenter exhibtorDetailsPresenter;
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

        Bundle bundle=this.getArguments();
      /*  if (bundle!=null)
        {
            *//*Link = bundle.getString( "video_link_exhibtor" );
            Title=bundle.getString("title_exhibtor");
            Address=bundle.getString("address_exhibtor");*//*
            ID_Exhibtor=bundle.getString("id");
            ExhibtorDetails();
            //Toast.makeText(getContext(), "id_user" +ID+"  fair"+DetailsExhibtionFragment.ID, Toast.LENGTH_SHORT).show();
        }*/

        networkConnection=new NetworkConnection(getContext());
        youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

        if (bundle!=null)
        {

            Link = bundle.getString("video_link");
            Title=bundle.getString("title");
            Description=bundle.getString("description");
            Address=bundle.getString("address");
            ID=bundle.getString("id");
            UserId=bundle.getString("user_id");
            Img=bundle.getString("imgg");
            Link360=bundle.getString("link_360");
            Hole1=bundle.getString("hole1");
            Hole2=bundle.getString("hole2");
            Hole3=bundle.getString("hole3");
            Hole4=bundle.getString("hole4");

            Visiblity=bundle.getString("visibilty");
            Under=bundle.getString("registerFromCurExhib");
            Img_or_video=bundle.getString("img_or_video");
          // Toast.makeText(getContext(), Hole1, Toast.LENGTH_SHORT).show();

            // FromCur=bundle.getString("registerFromCurExhib");
            //  Toast.makeText(getContext(), Under, Toast.LENGTH_SHORT).show();

            //RegisterFromCurExhib = bundle.getString("registerFromCurExhib");
            // Visitor=bundle.getString("visitor");
            //"visitor","no_from_under"

           /* title.setText(Title);
            description.setText(Description);
            address.setText(Address);*/
            // Toast.makeText(getContext(), UserId, Toast.LENGTH_SHORT).show();
            textToolbar.setText(Title);
            // youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);

            if (Img_or_video.equals("under"))
            {
                /**/

                if (Link!=null)  {
                    //Toast.makeText(getContext(), "videooooo", Toast.LENGTH_SHORT).show();
                    imageView.setVisibility(View.GONE);
                    youTubePlayerSupportFragment.getView().setVisibility(View.VISIBLE);
                    youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);
                }
                else
                {
                    //Toast.makeText(getContext(), "imggggg", Toast.LENGTH_SHORT).show();

                    youTubePlayerSupportFragment.getView().setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load("http://electronic-expos.com"+Img).into(imageView);

                }
            }else  if (Img_or_video.equals("current"))
            {
                /**/

                if (Link!=null)  {
                    //Toast.makeText(getContext(), "videooooo", Toast.LENGTH_SHORT).show();
                    imageView.setVisibility(View.GONE);
                    youTubePlayerSupportFragment.getView().setVisibility(View.VISIBLE);
                    youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);
                }
                else
                {
                    //Toast.makeText(getContext(), "imggggg", Toast.LENGTH_SHORT).show();

                    youTubePlayerSupportFragment.getView().setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load("http://electronic-expos.com"+Img).into(imageView);

                }
            }else  if (Img_or_video.equals("home_current"))
            {
                /**/

                if (Link!=null)  {
                    //Toast.makeText(getContext(), "videooooo", Toast.LENGTH_SHORT).show();
                    imageView.setVisibility(View.GONE);
                    youTubePlayerSupportFragment.getView().setVisibility(View.VISIBLE);
                    youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);
                }
                else
                {
                    //Toast.makeText(getContext(), "imggggg", Toast.LENGTH_SHORT).show();

                    youTubePlayerSupportFragment.getView().setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load("http://electronic-expos.com"+Img).into(imageView);

                }
            } else  if (Img_or_video.equals("previous"))
            {
                /**/

                if (Link!=null)  {
                    // Toast.makeText(getContext(), "videooooo", Toast.LENGTH_SHORT).show();
                    imageView.setVisibility(View.GONE);
                    youTubePlayerSupportFragment.getView().setVisibility(View.VISIBLE);
                    youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);
                }
                else
                {
                    // Toast.makeText(getContext(), "imggggg", Toast.LENGTH_SHORT).show();

                    youTubePlayerSupportFragment.getView().setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load("http://electronic-expos.com"+Img).into(imageView);

                }
            }


            if(Visiblity.equals("yes"))
            {
                registerNowBtn.setVisibility(View.VISIBLE);
                registerAsExhibtor.setVisibility(View.VISIBLE);

            }else
            {
                registerNowBtn.setVisibility(View.GONE);
                registerAsExhibtor.setVisibility(View.GONE);
            }



        }
        // Toast.makeText(getContext(),Img, Toast.LENGTH_SHORT).show();


        OrganizersAndServiceProviders();
        HallOne();
        HallTwo();
        HallThree();
        HallFour();
        Sponsors();
        Exhibtors();
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getActivity(), com.exhibtion.activity.RegisterActivity.class);


                i.putExtra("registerFromCurExhib","no_under");

                i.putExtra("registerFromCurExhib","yes");

                //Toast.makeText(getContext(), Under, Toast.LENGTH_SHORT).show();
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        registerAsExhibtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getActivity(), com.exhibtion.activity.RegisterInExhibtionActivity.class);
                i.putExtra("registerFromCurExhib","yes");
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
//        Toast.makeText(getContext(), Link360, Toast.LENGTH_SHORT).show();

        btnExhibtionDiagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), com.exhibtion.activity.ExhibtionDiagramActivity.class);
                i.putExtra("fairId",ID);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });
        link360Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(Link360));
                startActivity(Getintent);


            }
        });

        return view;
    }

  /*  private void ExhibtorDetails() {
        exhibtorDetailsPresenter=new com.exhibtion.presenter.ExhibtorDetailsPresenter(getContext(),this);
        if(Language.isRTL()) {
            exhibtorDetailsPresenter.getExhibtorDetailsResult("ar", UserId); //id user
        }else {
            exhibtorDetailsPresenter.getExhibtorDetailsResult("en", UserId);
        }
    }*/

    private void HallFour() {
        hallFourPresenter=new com.exhibtion.presenter.HallFourPresenter(getContext(),this);
        hallFourPresenter.getHallFourResult(ID  );
    }

    private void HallThree() {
        hallThreePresenter=new com.exhibtion.presenter.HallThreePresenter(getContext(),this);
        hallThreePresenter.getHallThreeResult(ID  );
    }

    private void HallTwo() {
        hallTwoPresenter=new com.exhibtion.presenter.HallTwoPresenter(getContext(),this);
        hallTwoPresenter.getHallTwoResult(ID  );
    }

    private void HallOne() {
        hallOnePresenter=new com.exhibtion.presenter.HallOnePresenter(getContext(),this);
        hallOnePresenter.getHallOneResult(ID  );
    }


    private void Exhibtors() {
        exhibtorsPresenter=new com.exhibtion.presenter.ExhibtorsPresenter(getContext(),this);

        if(Language.isRTL()) {
            exhibtorsPresenter.getExhibtorsResult("ar", UserId); //id user
        }else {
            exhibtorsPresenter.getExhibtorsResult("en", UserId);
        }
    }

    private void Sponsors() {
        sponsorPresenter=new com.exhibtion.presenter.SponsorPresenter(getContext(),this);
        if(Language.isRTL()) {
            sponsorPresenter.getSponsorList("ar",ID);
        }else
        {
            sponsorPresenter.getSponsorList("en",ID);
        }
    }

    private void OrganizersAndServiceProviders() {
        if(networkConnection.isNetworkAvailable(getContext())) {
            organizersAndServiceProvidersPresenter = new com.exhibtion.presenter.OrganizersAndServiceProvidersPresenter(getContext(), this);
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
        /*title=view.findViewById(R.id.details_exhibtion_title);
        description=view.findViewById(R.id.details_exhibtion_description);
        address=view.findViewById(R.id.details_exhibtion_address);*/
        recyclerViewOrganizers=view.findViewById(R.id.details_exhibtion_recycler_organizers);

        recyclerViewSponsor=view.findViewById(R.id.details_exhibtion_recycler_sponsors);
        textToolbar=view.findViewById(R.id.details_exhibtion_text_toolbar);

        recyclerViewExhibtors=view.findViewById(R.id.details_exhibtion_recycler_exhibtors);
        imageView=view.findViewById(R.id.details_exhibtion_img);
        registerNowBtn=view.findViewById(R.id.details_exhibtion_btn_register);
        registerAsExhibtor=view.findViewById(R.id.details_exhibtion_btn_exhibtor);


        hallOneSpinner=view.findViewById( R.id.details_exhibtion_spinner1 );
        hallTwoSpinner=view.findViewById( R.id.details_exhibtion_spinner2 );
        hallThreeSpinner=view.findViewById( R.id.details_exhibtion_spinner3 );
        hallFourSpinner=view.findViewById( R.id.details_exhibtion_spinner4 );
        link360Btn=view.findViewById( R.id.details_exhibtors_btn_link360 );
        btnExhibtionDiagram=view.findViewById( R.id.details_exhibtion_btn_diagram );
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
            if (Link != null) {
                imageView.setVisibility(View.GONE);
                youTubePlayer.loadVideo(Link);
            }
            /*    else
            {
                imageView.setVisibility(View.VISIBLE);
                youTubePlayerSupportFragment.getView().setVisibility(View.GONE);
                Glide.with(getContext()).load("http://eelectronicexpo.com"+Img).into(imageView);
            }*/

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
    public void showOrganizersAndServiceProvidersList(List<com.exhibtion.model.OrganizersAndServiceProvidersData> organizersAndServiceProvidersDataList) {

        organizersAndServiceProvidersAdapter=new com.exhibtion.adapter.OrganizersAndServiceProvidersAdapter( getContext(),organizersAndServiceProvidersDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewOrganizers.setLayoutManager(linearLayoutManager);
        recyclerViewOrganizers.setAdapter( organizersAndServiceProvidersAdapter );
    }

    @Override
    public void showSponsorData(List<com.exhibtion.model.SponsorData> sponsorDataList) {
        sponsorAdapter=new com.exhibtion.adapter.SponsorAdapter( getContext(),sponsorDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSponsor.setLayoutManager(linearLayoutManager);
        recyclerViewSponsor.setAdapter( sponsorAdapter );
    }


    @Override
    public void showExhibtorsList(List<com.exhibtion.model.ExhibtorsData> exhibtorsDataList) {
        exhibtorsAdapter=new com.exhibtion.adapter.ExhibtorsAdapter(getContext(),exhibtorsDataList);
        exhibtorsAdapter.onClick(this);
        recyclerViewExhibtors.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerViewExhibtors.setAdapter(exhibtorsAdapter);

    }

    @Override
    public void showDetailsExhibtorsData(com.exhibtion.model.ExhibtorsData exhibtorsData) {
        com.exhibtion.fragment.DetailsExhibtorsFragment detailsExhibtorsFragment=new com.exhibtion.fragment.DetailsExhibtorsFragment();
        Bundle bundle=new Bundle();

        bundle.putString("id",String.valueOf(exhibtorsData.getId()));
        bundle.putString("title_exhibtor",exhibtorsData.getName());
        detailsExhibtorsFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add(R.id.content_navigation,detailsExhibtorsFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void showHallOneList(final List<com.exhibtion.model.HallOneData> hallOneDataList) {
        ArrayList<String> hallOneList=new ArrayList<>(  );
        for(int i=0;i<hallOneDataList.size();i++)
        {
            //hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallOneList.add( hallOneDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallOneAdapter =new com.exhibtion.adapter.HallOneAdapter( getContext(), R.layout.spinner_item);
        hallOneAdapter.addAll( hallOneList );
        if (Img_or_video.equals("current")) {
            hallOneAdapter.add(Hole1);
        }else if (Img_or_video.equals("under"))
        {
            hallOneAdapter.add(Hole1);
        }else if (Img_or_video.equals("home_current"))
        {
            if (!Hole1.equals(null))
            hallOneAdapter.add(Hole1);
        }else
        {
            hallOneAdapter.add(Hole1);
        }
        hallOneSpinner.setAdapter( hallOneAdapter );


        hallOneSpinner.setSelection( hallOneAdapter.getCount() );
        hallOneSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallOneSpinner.getSelectedItem()==Hole1)
                {

                }
                else
                {
                    HallOneModel=hallOneSpinner.getSelectedItem().toString();
                    for (i=0;i<hallOneDataList.size();i++)
                    {
                        if(hallOneDataList.get(i).getTitle().equals( HallOneModel ))
                        {
                            HallOneModelID=hallOneDataList.get(i).getId();
                        }
                    }
                    com.exhibtion.fragment.DetailsExhibtorsFragment detailsExhibtorsFragment=new com.exhibtion.fragment.DetailsExhibtorsFragment();
                    Bundle bundle=new Bundle(  );
                    bundle.putString( "id",String.valueOf(HallOneModelID));
                    detailsExhibtorsFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().add( R.id.content_navigation,
                            detailsExhibtorsFragment )
                            .addToBackStack( null ).commit();
                    // Toast.makeText(getContext(), String.valueOf(HallOneModelID), Toast.LENGTH_SHORT).show();
                    hallOnePresenter.getHallOneResult(HallOneModel  );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );



    }


   /* @Override
    public void showExhibtorDetailsListView(List<ExhibtorDetailsData> exhibtorDetailsDataList) {
        Link360=exhibtorDetailsDataList.get(0).getMap3D();
       // Toast.makeText(getContext(),"Link360   "+ Link360+"  "+UserId, Toast.LENGTH_SHORT).show();
        link360Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse(Link360));
                startActivity(Getintent);
            }
        });
    }*/

    @Override
    public void showError() {

    }

    @Override
    public void showHallTwoList(final List<com.exhibtion.model.HallTwoData> hallTwoDataList) {
        ArrayList<String> hallTwoList=new ArrayList<>(  );
        for(int i=0;i<hallTwoDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallTwoList.add( hallTwoDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallTwoAdapter =new com.exhibtion.adapter.HallTwoAdapter( getContext(), R.layout.spinner_item);
        hallTwoAdapter.addAll( hallTwoList );
        if (Img_or_video.equals("current")) {
            hallTwoAdapter.add(Hole2);
        }else if (Img_or_video.equals("under"))
        {
            hallTwoAdapter.add(Hole2);
        }else if (Img_or_video.equals("home_current"))
        {
            hallTwoAdapter.add(Hole2);
        }else
        {
            hallTwoAdapter.add(Hole2);
        }
        hallTwoSpinner.setAdapter( hallTwoAdapter );


        hallTwoSpinner.setSelection( hallTwoAdapter.getCount() );
        hallTwoSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallTwoSpinner.getSelectedItem()==Hole2)
                {

                }
                else
                {
                    HallTwoModel=hallTwoSpinner.getSelectedItem().toString();
                  /*  for (i=0;i<hallOneDataList.size();i++)
                    {
                        if(hallOneDataList.get(i).getTitle().equals( HallOneModel ))
                        {
                            HallOneModelID=hallOneDataList.get(i).getId();
                        }
                    }*/
                    for (i=0;i<hallTwoDataList.size();i++)
                    {
                        if(hallTwoDataList.get(i).getTitle().equals( HallTwoModel ))
                        {
                            HallTwoModelID=hallTwoDataList.get(i).getId();
                        }
                    }
                    com.exhibtion.fragment.DetailsExhibtorsFragment detailsExhibtorsFragment=new com.exhibtion.fragment.DetailsExhibtorsFragment();
                    Bundle bundle=new Bundle(  );
                    bundle.putString( "id",String.valueOf(HallTwoModelID));
                    detailsExhibtorsFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().add( R.id.content_navigation,
                            detailsExhibtorsFragment )
                            .addToBackStack( null ).commit();
                    hallTwoPresenter.getHallTwoResult(HallTwoModel  );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


    }


    @Override
    public void showHallTwoError() {

    }

    @Override
    public void showHallThreeList(final List<com.exhibtion.model.HallThreeData> hallThreeDataList) {
        ArrayList<String> hallThreeList=new ArrayList<>(  );
        for(int i=0;i<hallThreeDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallThreeList.add( hallThreeDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallThreeAdapter =new com.exhibtion.adapter.HallThreeAdapter( getContext(), R.layout.spinner_item);
        hallThreeAdapter.addAll( hallThreeList );
        if (Img_or_video.equals("current")) {
            hallThreeAdapter.add(Hole3);
        }else if (Img_or_video.equals("under"))
        {
            hallThreeAdapter.add(Hole3);
        }else if (Img_or_video.equals("home_current"))
        {
            hallThreeAdapter.add(Hole3);
        }else
        {
            hallThreeAdapter.add(Hole3);
        }
        hallThreeSpinner.setAdapter( hallThreeAdapter );


        hallThreeSpinner.setSelection( hallThreeAdapter.getCount() );
        hallThreeSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallThreeSpinner.getSelectedItem()==Hole3)
                {

                }
                else
                {
                    HallThreeModel=hallThreeSpinner.getSelectedItem().toString();
                  /*  for (i=0;i<hallOneDataList.size();i++)
                    {
                        if(hallOneDataList.get(i).getTitle().equals( HallOneModel ))
                        {
                            HallOneModelID=hallOneDataList.get(i).getId();
                        }
                    }*/
                    for (i=0;i<hallThreeDataList.size();i++)
                    {
                        if(hallThreeDataList.get(i).getTitle().equals( HallThreeModel ))
                        {
                            HallThreeModelID=hallThreeDataList.get(i).getId();
                        }
                    }
                    com.exhibtion.fragment.DetailsExhibtorsFragment detailsExhibtorsFragment=new com.exhibtion.fragment.DetailsExhibtorsFragment();
                    Bundle bundle=new Bundle(  );
                    bundle.putString( "id",String.valueOf(HallThreeModelID));
                    detailsExhibtorsFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().add( R.id.content_navigation,
                            detailsExhibtorsFragment )
                            .addToBackStack( null ).commit();

                    hallThreePresenter.getHallThreeResult(HallThreeModel  );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


    }

    @Override
    public void showHallThreeError() {

    }

    @Override
    public void showHallFourList(final List<com.exhibtion.model.HallFourData> hallFourDataList) {
        ArrayList<String> hallFourList=new ArrayList<>(  );
        for(int i=0;i<hallFourDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallFourList.add( hallFourDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallFourAdapter =new com.exhibtion.adapter.HallFourAdapter( getContext(), R.layout.spinner_item);
        hallFourAdapter.addAll( hallFourList );
        if (Img_or_video.equals("current")) {
            hallFourAdapter.add(Hole4);
        }else if (Img_or_video.equals("under"))
        {
            hallFourAdapter.add(Hole4);
        }else if (Img_or_video.equals("home_current"))
        {
            hallFourAdapter.add(Hole4);
        }else
        {
            hallFourAdapter.add(Hole4);
        }
        hallFourSpinner.setAdapter( hallFourAdapter );


        hallFourSpinner.setSelection( hallFourAdapter.getCount() );
        hallFourSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallFourSpinner.getSelectedItem()==Hole4)
                {

                }
                else
                {
                    HallFourModel=hallFourSpinner.getSelectedItem().toString();
                  /*  for (i=0;i<hallOneDataList.size();i++)
                    {
                        if(hallOneDataList.get(i).getTitle().equals( HallOneModel ))
                        {
                            HallOneModelID=hallOneDataList.get(i).getId();
                        }
                    }*/
                    for (i=0;i<hallFourDataList.size();i++)
                    {
                        if(hallFourDataList.get(i).getTitle().equals( HallOneModel ))
                        {
                            HallFourModelID=hallFourDataList.get(i).getId();
                        }
                    }
                    com.exhibtion.fragment.DetailsExhibtorsFragment detailsExhibtorsFragment=new com.exhibtion.fragment.DetailsExhibtorsFragment();
                    Bundle bundle=new Bundle(  );
                    bundle.putString( "id",String.valueOf(HallFourModelID));
                    detailsExhibtorsFragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().add( R.id.content_navigation,
                            detailsExhibtorsFragment )
                            .addToBackStack( null ).commit();
                    hallFourPresenter.getHallFourResult(HallFourModel  );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        } );


    }

    @Override
    public void showHallFourError() {

    }
}