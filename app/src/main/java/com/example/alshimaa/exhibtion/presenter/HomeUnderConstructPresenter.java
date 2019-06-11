package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HomeUnderConstructResponse;
import com.exhibtion.model.PreviousExhibtionResponse;
import com.exhibtion.view.HomeUnderConstructView;
import com.exhibtion.view.PreviousExhibtionView;

import com.exhibtion.fragment.HomeFragment;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeUnderConstructPresenter {
    Context context;
    HomeUnderConstructView homeUnderConstructView;

    public HomeUnderConstructPresenter(Context context, HomeFragment homeUnderConstructView) {
        this.context = context;
        this.homeUnderConstructView = homeUnderConstructView;
    }

    public void getHomeUnderConstructResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<HomeUnderConstructResponse> call = service.getHomeUnderConstructData(map );
        call.enqueue( new Callback<HomeUnderConstructResponse>() {
            @Override
            public void onResponse(Call<HomeUnderConstructResponse> call, Response<HomeUnderConstructResponse> response) {
                if(response.isSuccessful()) {
                    homeUnderConstructView.showHomeUnderConstructList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeUnderConstructResponse> call, Throwable t) {
                homeUnderConstructView.showError();
            }
        } );
    }
}
