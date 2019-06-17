package com.exhibtion.fragment;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.ShareCompat;
import android.widget.Toast;

/*import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.YoutubeConfig;
import com.example.alshimaa.exhibtion.activity.ExhibtorSummaryActivity;
import com.example.alshimaa.exhibtion.activity.MapActivity;
import com.example.alshimaa.exhibtion.activity.RegisterActivity;
import com.example.alshimaa.exhibtion.activity.RegisterNowActivity;
import com.example.alshimaa.exhibtion.adapter.EShopAdapter;
import com.example.alshimaa.exhibtion.adapter.HomeUnderConstructAdapter;
import com.example.alshimaa.exhibtion.adapter.ServicesProvidedAdapter;
import com.example.alshimaa.exhibtion.model.EShopData;
import com.example.alshimaa.exhibtion.model.ExhibtorDetailsData;
import com.example.alshimaa.exhibtion.model.ServicesProvidedData;
import com.example.alshimaa.exhibtion.presenter.EShopPresenter;
import com.example.alshimaa.exhibtion.presenter.ExhibtorDetailsPresenter;
import com.example.alshimaa.exhibtion.presenter.ExhibtorsPresenter;
import com.example.alshimaa.exhibtion.presenter.HomeUnderConstructPresenter;
import com.example.alshimaa.exhibtion.presenter.ServicesProvidedPresenter;
import com.example.alshimaa.exhibtion.view.EShopView;
import com.example.alshimaa.exhibtion.view.ExhibtorDetailsListView;
import com.example.alshimaa.exhibtion.view.ServicesProvidedView;*/
import com.example.alshimaa.exhibtion.presenter.ServicesProvidedPresenter;
import com.exhibtion.Language;
import com.exhibtion.NetworkConnection;
import com.exhibtion.R;
import com.exhibtion.YoutubeConfig;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsExhibtorsFragment extends Fragment implements YouTubePlayer.OnInitializedListener
    , com.exhibtion.view.ServicesProvidedView, com.exhibtion.view.EShopView, com.exhibtion.view.ExhibtorDetailsListView
{

    public static String Link,Title,ID,WebsiteLink,Phone;
    TextView title,address,phone,email,websiteLink,summaryTxt;


    NetworkConnection networkConnection;

    public static final int RECOVERY_DIALOG_REQUEST=1;
    private YouTubePlayerSupportFragment youTubePlayerSupportFragment;

    TextView textToolbar;
    Button vacantJopsBtn;

    RecyclerView recyclerViewservicesProvided;
    com.exhibtion.adapter.ServicesProvidedAdapter servicesProvidedAdapter;
    ServicesProvidedPresenter servicesProvidedPresenter;

    RecyclerView recyclerViewEShop;
    com.exhibtion.adapter.EShopAdapter eShopAdapter;
    com.exhibtion.presenter.EShopPresenter eShopPresenter;
    Button contactUsBtn,summaryBtn;
    public  String Summary;

    RecyclerView recyclerViewdetailsExhib;
    //EShopAdapter eShopAdapter;
    com.exhibtion.presenter.ExhibtorDetailsPresenter exhibtorDetailsPresenter;
    List<com.exhibtion.model.ExhibtorDetailsData> exhibtorDetailsDataList=new ArrayList<>();

    ImageView iconWhats,iconFacebook,iconInstagram,iconTwitter,iconSnap;
    TextView linkMapTxt;
    String LinkMap;

    Intent intent;

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
       // Toast.makeText(getContext(),String.valueOf(exhibtorDetailsDataList.get(0).getFacebookLink()) , Toast.LENGTH_SHORT).show();
        networkConnection=new NetworkConnection(getContext());

        Bundle bundle=this.getArguments();
        if (bundle!=null)
        {
            /*Link = bundle.getString( "video_link_exhibtor" );
            Title=bundle.getString("title_exhibtor");
            Address=bundle.getString("address_exhibtor");*/
            ID=bundle.getString("id");
            Title=bundle.getString("title_exhibtor");
           /* Phone=bundle.getString("phone_exhibtor");
            Email=bundle.getString("email_exhibtor");
            WebsiteLink=bundle.getString("website_link");*/

            /*title.setText(Title);
            address.setText(Address);
            phone.setText(Phone);
            email.setText(Email);
            websiteLink.setText(WebsiteLink);*/

            textToolbar.setText(Title);

            ExhibtorDetails();

             //Toast.makeText(getContext(), "id_user" +ID+"  fair"+DetailsExhibtionFragment.ID, Toast.LENGTH_SHORT).show();
        }
       // Toast.makeText(getContext(), "id_user" +ID+"  fair"+ com.exhibtion.fragment.DetailsExhibtionFragment.ID, Toast.LENGTH_SHORT).show();
        vacantJopsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToJopsPage();
            }
        });
        ServicesProvided();
        EShop();
        this.exhibtorDetailsDataList=exhibtorDetailsDataList;

        iconWhats.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.setComponent(new ComponentName("com.whatsapp","com.whatsapp.Conversation"));
                sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(exhibtorDetailsDataList.get(0).getPhone())+"@s.whatsapp.net");
                startActivity(sendIntent);
            }
        } );

        iconFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FacebookLink=exhibtorDetailsDataList.get(0).getFacebookLink();
if(FacebookLink!=null) {
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(FacebookLink));
    startActivity(intent);
}
                }


        });
        iconInstagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String InstegramLink=exhibtorDetailsDataList.get(0).getInstgramLink();
                if(InstegramLink!=null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(InstegramLink));
                    startActivity(intent);
                }
            }
        });
        iconTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TwitterLink=exhibtorDetailsDataList.get(0).getTweeterLink();
                if(TwitterLink!=null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TwitterLink));
                    startActivity(intent);
                }

            }
        });
        iconSnap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String SnapLink=exhibtorDetailsDataList.get(0).getSnapLink();
                if(SnapLink!=null) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(SnapLink));
                    startActivity(intent);
                }


            }
        });
        contactUsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToCallUsPage();
            }
        });
        summaryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), com.exhibtion.activity.ExhibtorSummaryActivity.class);
                 i.putExtra("nabza",Summary);
                 startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);


            }
        });
        linkMapTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), com.exhibtion.activity.MapActivity.class);
                i.putExtra("link_map",LinkMap);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0,0);
                /*WebView webview = (WebView) view.findViewById(R.id.webView);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadData(  , "text/html", "utf-8");
                WebSettings webViewSettings = webview.getSettings();
                webViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webViewSettings.setJavaScriptEnabled(true);
                webViewSettings.setBuiltInZoomControls(true);
                webViewSettings.setPluginState(WebSettings.PluginState.ON);*/
            }
        });
        return view;
    }

    private void ExhibtorDetails() {
        exhibtorDetailsPresenter=new com.exhibtion.presenter.ExhibtorDetailsPresenter(getContext(),this);

        if(Language.isRTL()) {
            exhibtorDetailsPresenter.getExhibtorDetailsResult("ar", ID); //id user
        }else {
            exhibtorDetailsPresenter.getExhibtorDetailsResult("en", ID);
        }

    }

    private void goToCallUsPage() {
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,new com.exhibtion.fragment.CallUsFragment())
                .addToBackStack(null).commit();
    }

    private void EShop() {
        eShopPresenter=new com.exhibtion.presenter.EShopPresenter(getContext(),this);
        if(Language.isRTL()) {
            eShopPresenter.getEShopResult("ar", com.exhibtion.fragment.DetailsExhibtionFragment.ID,ID);
        }else {
            eShopPresenter.getEShopResult("en", com.exhibtion.fragment.DetailsExhibtionFragment.ID,ID);
        }
    }

    private void ServicesProvided() {
        servicesProvidedPresenter=new ServicesProvidedPresenter(getContext(),this);
        if(Language.isRTL()) {
            servicesProvidedPresenter.getServicesProvidedResult("ar", com.exhibtion.fragment.DetailsExhibtionFragment.ID,ID);// user id ,fair id
        }else {
            servicesProvidedPresenter.getServicesProvidedResult("en", com.exhibtion.fragment.DetailsExhibtionFragment.ID,ID);
        }
    }

    private void goToJopsPage() {
        getFragmentManager().beginTransaction().replace(R.id.content_navigation,new com.exhibtion.fragment.JopsFragment())
                .addToBackStack(null).commit();
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
    vacantJopsBtn=view.findViewById(R.id.details_exhibtors_btn_jops);
    recyclerViewservicesProvided=view.findViewById(R.id.details_exhibtors_recycler_services);
    recyclerViewEShop=view.findViewById(R.id.details_exhibtors_recycler_E_shop);
    contactUsBtn=view.findViewById(R.id.details_exhibtors_btn_contact_us);
    iconWhats=view.findViewById(R.id.details_exhibtors_icon_whats);
        iconFacebook=view.findViewById(R.id.details_exhibtors_icon_face);
        iconInstagram=view.findViewById(R.id.details_exhibtors_icon_instegram);
        iconTwitter=view.findViewById(R.id.details_exhibtors_icon_twitter);
        iconSnap=view.findViewById(R.id.details_exhibtors_icon_snap);
    summaryBtn=view.findViewById(R.id.details_exhibtors_btn_description);
    linkMapTxt=view.findViewById(R.id.details_exhibtors_website);

        //summaryTxt=view.findViewById(R.id.details_exhibtors_text_description);


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
           //  String url=Link.substring( Link.lastIndexOf( "=")+1  );
            if(exhibtorDetailsDataList.size()!=0) {
                youTubePlayer.loadVideo(exhibtorDetailsDataList.get(0).getYoutubeLink());
               // Toast.makeText(getContext(), "" + exhibtorDetailsDataList.get(0).isYoutubeLink(), Toast.LENGTH_SHORT).show();

            }
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

    @Override
    public void showServicesProvidedList(List<com.exhibtion.model.ServicesProvidedData> servicesProvidedDataList) {
        servicesProvidedAdapter=new com.exhibtion.adapter.ServicesProvidedAdapter( getContext(),servicesProvidedDataList );
        //homeProductAdapter.onClick(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerViewservicesProvided.setLayoutManager(linearLayoutManager);
        recyclerViewservicesProvided.setAdapter( servicesProvidedAdapter );
      //  swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void showEshopDataList(List<com.exhibtion.model.EShopData> eShopDataList) {
        eShopAdapter=new com.exhibtion.adapter.EShopAdapter( getContext(),eShopDataList );
        //homeProductAdapter.onClick(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerViewEShop.setLayoutManager(gridLayoutManager);
        recyclerViewEShop.setAdapter( eShopAdapter );

    }

    @Override
    public void showExhibtorDetailsListView(List<com.exhibtion.model.ExhibtorDetailsData> exhibtorDetailsDataList) {
     Summary=exhibtorDetailsDataList.get(0).getDescription();
        LinkMap=exhibtorDetailsDataList.get(0).getMapFair();
        String youtube=exhibtorDetailsDataList.get(0).getYoutubeLink();
        if(youtube==null){

        }else {
            youTubePlayerSupportFragment.initialize(YoutubeConfig.DEVELOPER_KEY, this);
        }
        this.exhibtorDetailsDataList=exhibtorDetailsDataList;
        title.setText(exhibtorDetailsDataList.get(0).getName());
        address.setText(exhibtorDetailsDataList.get(0).getAddress());
        Phone=exhibtorDetailsDataList.get(0).getPhone();
        phone.setText(Phone);
        email.setText(exhibtorDetailsDataList.get(0).getEmail());
        WebsiteLink=exhibtorDetailsDataList.get(0).getWebsiteLink();
        websiteLink.setText(WebsiteLink);
        //Linkify.addLinks(websiteLink, Linkify.WEB_URLS);
        /*Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, WebsiteLink);
        StartActivity(Intent.createChooser(i, "Share URL"));*/
        websiteLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Linkify.addLinks(websiteLink, Linkify.WEB_URLS);
                 ShareCompat.IntentBuilder.from(getActivity())
                        .setType("text/plain")
                        .setText(WebsiteLink)
                        .getIntent();

            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( phone != null ) {
                    Intent intent = new Intent(android.content.Intent.ACTION_CALL, Uri.parse("tel: "+Phone));
                    startActivity(intent);
                }
            }
        });




        //summaryTxt.setText(exhibtorDetailsDataList.get(0).getDescription());
    }

    @Override
    public void showError() {

    }
}

