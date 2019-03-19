package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HomeUnderConstructResponse;
import com.example.alshimaa.exhibtion.model.NavItemServiceProviderResponse;
import com.example.alshimaa.exhibtion.view.HomeUnderConstructView;
import com.example.alshimaa.exhibtion.view.NavItemServiceProvView;

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
}

