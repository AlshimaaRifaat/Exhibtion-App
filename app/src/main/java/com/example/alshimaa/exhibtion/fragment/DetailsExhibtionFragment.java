package com.example.alshimaa.exhibtion.fragment;


import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
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
import com.example.alshimaa.exhibtion.view.OrganizersAndServiceProvidersView;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtionFragment extends Fragment implements
        YouTubePlayer.OnInitializedListener,OrganizersAndServiceProvidersView
        ,ExhibtorsView,DetailsExhibtorsView,HallOneView
{
    HallOnePresenter hallOnePresenter;
    Spinner hallOneSpinner;
    Integer HallOneModelID;
    String HallOneModel;
    HallOneAdapter hallOneAdapter;


    HallTwoPresenter hallTwoPresenter;
    Spinner hallTwoSpinner;
    Integer HallTwoModelID;
    String HallTwoModel;
    HallTwoAdapter hallTwoAdapter;

    HallThreePresenter hallThreePresenter;
    Spinner hallThreeSpinner;
    Integer HallThreeModelID;
    String HallThreeModel;
    HallThreeAdapter hallThreeAdapter;

    HallFourPresenter hallFourPresenter;
    Spinner hallFourSpinner;
    Integer HallFourModelID;
    String HallFourModel;
    HallFourAdapter hallFourAdapter;


    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;
   public static String Link,Title,Description,Address,ID,UserId,Logo,Visiblity,UserId_underConstruct;
    TextView title,description,address;
    ImageView logo;

    RecyclerView recyclerViewOrganizers;
    OrganizersAndServiceProvidersAdapter organizersAndServiceProvidersAdapter;
    OrganizersAndServiceProvidersPresenter organizersAndServiceProvidersPresenter;

    SponsorPresenter sponsorPresenter;

    RecyclerView recyclerViewSponsor;


    NetworkConnection networkConnection;

    TextView textToolbar;

    RecyclerView recyclerViewExhibtors;
    ExhibtorsAdapter exhibtorsAdapter;
    ExhibtorsPresenter exhibtorsPresenter;

   public static Button registerNowBtn;

    public static Button registerAsExhibtor;
    Intent intent;

    SponsorAdapter sponsorAdapter;


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
            UserId=bundle.getString("user_id");
            Logo=bundle.getString("logo");
            Visiblity=bundle.getString("visibilty");

            title.setText(Title);
            description.setText(Description);
            address.setText(Address);
          // Toast.makeText(getContext(), UserId, Toast.LENGTH_SHORT).show();
            textToolbar.setText(Title);
            Glide.with(getContext()).load("http://eelectronicexpo.com"+Logo).into(logo);

            if(Visiblity.equals("yes"))
            {
                registerNowBtn.setVisibility(View.VISIBLE);
                registerAsExhibtor.setVisibility(View.VISIBLE);
            }
            else
            {
                registerNowBtn.setVisibility(View.GONE);
                registerAsExhibtor.setVisibility(View.GONE);
            }

        }
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


        Intent i = new Intent(getActivity(), RegisterActivity.class);
        i.putExtra("registerFromCurExhib","yes");
        startActivity(i);
        ((Activity) getActivity()).overridePendingTransition(0,0);
    }
});
        registerAsExhibtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  Toast.makeText(getActivity(), ""+homeUnderConstructData.getId(), Toast.LENGTH_SHORT).show();


                Intent i = new Intent(getActivity(), RegisterInExhibtionActivity.class);
                i.putExtra("registerFromCurExhib","yes");
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }
        });

        return view;
    }

    private void HallFour() {
        hallFourPresenter=new HallFourPresenter(getContext(),this);
        hallFourPresenter.getHallFourResult(ID  );
    }

    private void HallThree() {
        hallThreePresenter=new HallThreePresenter(getContext(),this);
        hallThreePresenter.getHallThreeResult(ID  );
    }

    private void HallTwo() {
        hallTwoPresenter=new HallTwoPresenter(getContext(),this);
        hallTwoPresenter.getHallTwoResult(ID  );
    }

    private void HallOne() {
        hallOnePresenter=new HallOnePresenter(getContext(),this);
        hallOnePresenter.getHallOneResult(ID  );
    }


    private void Exhibtors() {
        exhibtorsPresenter=new ExhibtorsPresenter(getContext(),this);

        if(Language.isRTL()) {
            exhibtorsPresenter.getExhibtorsResult("ar", UserId); //id user
        }else {
            exhibtorsPresenter.getExhibtorsResult("en", UserId);
        }
    }

    private void Sponsors() {
        sponsorPresenter=new SponsorPresenter(getContext(),this);
        if(Language.isRTL()) {
            sponsorPresenter.getSponsorList("ar",ID);
        }else
        {
            sponsorPresenter.getSponsorList("en",ID);
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
        logo=view.findViewById(R.id.details_exhibtion_logo);
        registerNowBtn=view.findViewById(R.id.details_exhibtion_btn_register);
        registerAsExhibtor=view.findViewById(R.id.details_exhibtion_btn_exhibtor);


        hallOneSpinner=view.findViewById( R.id.details_exhibtion_spinner1 );
        hallTwoSpinner=view.findViewById( R.id.details_exhibtion_spinner2 );
        hallThreeSpinner=view.findViewById( R.id.details_exhibtion_spinner3 );
        hallFourSpinner=view.findViewById( R.id.details_exhibtion_spinner4 );
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
    public void showSponsorData(List<SponsorData> sponsorDataList) {
        sponsorAdapter=new SponsorAdapter( getContext(),sponsorDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL,false);
        recyclerViewSponsor.setLayoutManager(linearLayoutManager);
        recyclerViewSponsor.setAdapter( sponsorAdapter );
    }


    @Override
    public void showExhibtorsList(List<ExhibtorsData> exhibtorsDataList) {
        exhibtorsAdapter=new ExhibtorsAdapter(getContext(),exhibtorsDataList);
        exhibtorsAdapter.onClick(this);
        recyclerViewExhibtors.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerViewExhibtors.setAdapter(exhibtorsAdapter);

    }

    @Override
    public void showDetailsExhibtorsData(ExhibtorsData exhibtorsData) {
        DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
        Bundle bundle=new Bundle();

        bundle.putString("id",String.valueOf(exhibtorsData.getId()));
        bundle.putString("title_exhibtor",exhibtorsData.getName());
        detailsExhibtorsFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add(R.id.content_navigation,detailsExhibtorsFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void showHallOneList(final List<HallOneData> hallOneDataList) {
        ArrayList<String> hallOneList=new ArrayList<>(  );
        for(int i=0;i<hallOneDataList.size();i++)
        {
            //hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallOneList.add( hallOneDataList.get( i ).getTitle() );
           // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallOneAdapter =new HallOneAdapter( getContext(), R.layout.spinner_item);
        hallOneAdapter.addAll( hallOneList );
        hallOneAdapter.add( getResources().getString(R.string.Hall_1));
        hallOneSpinner.setAdapter( hallOneAdapter );


        hallOneSpinner.setSelection( hallOneAdapter.getCount() );
        hallOneSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallOneSpinner.getSelectedItem()==getResources().getString(R.string.Hall_1))
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
                    DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
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



    @Override
    public void showError() {

    }

    @Override
    public void showHallTwoList(final List<HallTwoData> hallTwoDataList) {
        ArrayList<String> hallTwoList=new ArrayList<>(  );
        for(int i=0;i<hallTwoDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallTwoList.add( hallTwoDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallTwoAdapter =new HallTwoAdapter( getContext(), R.layout.spinner_item);
        hallTwoAdapter.addAll( hallTwoList );
        hallTwoAdapter.add( getResources().getString(R.string.Hall_2));
        hallTwoSpinner.setAdapter( hallTwoAdapter );


        hallTwoSpinner.setSelection( hallTwoAdapter.getCount() );
        hallTwoSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallTwoSpinner.getSelectedItem()==getResources().getString(R.string.Hall_2))
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
                    DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
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
    public void showHallThreeList(final List<HallThreeData> hallThreeDataList) {
        ArrayList<String> hallThreeList=new ArrayList<>(  );
        for(int i=0;i<hallThreeDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallThreeList.add( hallThreeDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallThreeAdapter =new HallThreeAdapter( getContext(), R.layout.spinner_item);
        hallThreeAdapter.addAll( hallThreeList );
        hallThreeAdapter.add( getResources().getString(R.string.Hall_3));
        hallThreeSpinner.setAdapter( hallThreeAdapter );


        hallThreeSpinner.setSelection( hallThreeAdapter.getCount() );
        hallThreeSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallThreeSpinner.getSelectedItem()==getResources().getString(R.string.Hall_3))
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
                    DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
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
    public void showHallFourList(final List<HallFourData> hallFourDataList) {
        ArrayList<String> hallFourList=new ArrayList<>(  );
        for(int i=0;i<hallFourDataList.size();i++)
        {
            // hallOneList.add(String.valueOf(hallOneDataList.get( i ).getId() ) );
            hallFourList.add( hallFourDataList.get( i ).getTitle() );
            // hallOneList.add( hallOneDataList.get( i ).getImg() );

        }

        hallFourAdapter =new HallFourAdapter( getContext(), R.layout.spinner_item);
        hallFourAdapter.addAll( hallFourList );
        hallFourAdapter.add( getResources().getString(R.string.Hall_4));
        hallFourSpinner.setAdapter( hallFourAdapter );


        hallFourSpinner.setSelection( hallFourAdapter.getCount() );
        hallFourSpinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (hallFourSpinner.getSelectedItem()==getResources().getString(R.string.Hall_4))
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
                    DetailsExhibtorsFragment detailsExhibtorsFragment=new DetailsExhibtorsFragment();
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
