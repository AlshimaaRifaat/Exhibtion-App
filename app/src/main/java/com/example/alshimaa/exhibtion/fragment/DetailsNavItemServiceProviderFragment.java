package com.exhibtion.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/*
import com.example.alshimaa.exhibtion.Language;
import com.example.alshimaa.exhibtion.NetworkConnection;
import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.CurrentExhibtionAdapter;
import com.example.alshimaa.exhibtion.adapter.DetailsNavItemServiceProvAdapter;
import com.example.alshimaa.exhibtion.model.DetailsNavItemServiceProvData;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderData;
import com.example.alshimaa.exhibtion.presenter.CurrentExhibtionPresenter;
import com.example.alshimaa.exhibtion.presenter.DetailsNavItemServiceProvPresenter;
import com.example.alshimaa.exhibtion.view.DetailsNavItemServiceProvView;
*/

import com.example.alshimaa.exhibtion.fragment.NestedetailsNavItemServiceProviderFragment;
import com.example.alshimaa.exhibtion.view.NestedDetailsNavItemServiceProviderView;
import com.exhibtion.Language;
import com.exhibtion.NetworkConnection;
import com.exhibtion.R;
import com.exhibtion.model.DetailsNavItemServiceProvData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsNavItemServiceProviderFragment extends Fragment implements com.exhibtion.view.DetailsNavItemServiceProvView,NestedDetailsNavItemServiceProviderView {

    NetworkConnection networkConnection;



    RecyclerView recyclerViewDetailsServiceProv;
    com.exhibtion.adapter.DetailsNavItemServiceProvAdapter detailsNavItemServiceProvAdapter;
    com.exhibtion.presenter.DetailsNavItemServiceProvPresenter detailsNavItemServiceProvPresenter;

    com.exhibtion.model.NavItemServiceProviderData navItemServiceProviderData;
    Bundle bundle;
    public DetailsNavItemServiceProviderFragment() {
        // Required empty public constructor
    }

   View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_details_nav_item_service, container, false);
        init();
        networkConnection=new NetworkConnection( getContext() );
        bundle=this.getArguments();
        if(bundle!=null)
        {
            navItemServiceProviderData=bundle.getParcelable("ServiceProviderItem");
        }

        DetailsServiceProv();
        return view;
    }

    private void DetailsServiceProv() {
        detailsNavItemServiceProvPresenter=new com.exhibtion.presenter.DetailsNavItemServiceProvPresenter(getContext(),this);
        if (Language.isRTL()) {
            detailsNavItemServiceProvPresenter.getDetailsNavItemServiceProvResult("ar",String.valueOf(navItemServiceProviderData.getId()));
        }else
        {
            detailsNavItemServiceProvPresenter.getDetailsNavItemServiceProvResult("en",String.valueOf(navItemServiceProviderData.getId()));
        }
    }

    private void init() {
        recyclerViewDetailsServiceProv=view.findViewById(R.id.details_nav_item_service_recycler);
    }

    @Override
    public void showDetailsNavItemServiceProvList(List<com.exhibtion.model.DetailsNavItemServiceProvData> detailsNavItemServiceProvDataList) {
        detailsNavItemServiceProvAdapter=new com.exhibtion.adapter.DetailsNavItemServiceProvAdapter( getContext(),detailsNavItemServiceProvDataList );
        detailsNavItemServiceProvAdapter.onClick(this);
        recyclerViewDetailsServiceProv.setLayoutManager( new GridLayoutManager(getContext(),2));
        recyclerViewDetailsServiceProv.setAdapter( detailsNavItemServiceProvAdapter );
    }

    @Override
    public void showNestedDetailsNavItemServiceProvList(DetailsNavItemServiceProvData detailsNavItemServiceProvData) {
        NestedetailsNavItemServiceProviderFragment nestedetailsNavItemServiceProviderFragment=new NestedetailsNavItemServiceProviderFragment();
        Bundle bundle=new Bundle(  );
        bundle.putString( "img",detailsNavItemServiceProvData.getImg());
        bundle.putString("title",detailsNavItemServiceProvData.getTitle());
        bundle.putString("description",detailsNavItemServiceProvData.getDescription());


        nestedetailsNavItemServiceProviderFragment.setArguments(bundle);

        getFragmentManager().beginTransaction().add( R.id.content_navigation,
                nestedetailsNavItemServiceProviderFragment )
                .addToBackStack( null ).commit();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), getResources().getString(R.string.NoResultFound), Toast.LENGTH_SHORT).show();
    }
}
