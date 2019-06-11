package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.R;
import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.CurrentExhibtionResponse;
import com.exhibtion.model.HomeUnderConstructResponse;
import com.exhibtion.model.NavItemServiceProviderResponse;
import com.exhibtion.view.HomeUnderConstructView;
import com.exhibtion.view.NavItemServiceProvView;

import com.exhibtion.fragment.HomeFragment;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavItemServiceProviderPresenter {
    Context context;
    NavItemServiceProvView navItemServiceProvView;

    public NavItemServiceProviderPresenter(Context context, NavItemServiceProvView navItemServiceProvView) {
        this.context = context;
        this.navItemServiceProvView = navItemServiceProvView;
    }

    public void getNavItemServiceProviderResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<NavItemServiceProviderResponse> call = service.getNavItemServiceProviderData(map );
        call.enqueue( new Callback<NavItemServiceProviderResponse>() {
            @Override
            public void onResponse(Call<NavItemServiceProviderResponse> call, Response<NavItemServiceProviderResponse> response) {
                if(response.isSuccessful()) {
                    navItemServiceProvView.showNavItemServiceProvList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<NavItemServiceProviderResponse> call, Throwable t) {
                navItemServiceProvView.showError();
            }
        } );
    }

    public void getSearchNavItemServiceProvResult(String Lang,String Key)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("key",Key);
        Service service = Client.getClient().create( Service.class );
        Call<NavItemServiceProviderResponse> call = service.getSearchNavItemServiceProvData(map );
        call.enqueue( new Callback<NavItemServiceProviderResponse>() {
            @Override
            public void onResponse(Call<NavItemServiceProviderResponse> call, Response<NavItemServiceProviderResponse> response) {
                if(response.isSuccessful()) {
                    navItemServiceProvView.showNavItemServiceProvList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<NavItemServiceProviderResponse> call, Throwable t) {
                navItemServiceProvView.showErrorSearch(context.getResources().getString(R.string.NoResultFound));
            }
        } );
    }



}

