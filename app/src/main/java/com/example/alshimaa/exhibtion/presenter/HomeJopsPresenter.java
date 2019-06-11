package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HomeJopsResponse;
import com.exhibtion.model.HomeUnderConstructResponse;
import com.exhibtion.view.HomeJopsView;
import com.exhibtion.view.HomeUnderConstructView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeJopsPresenter {
    Context context;
    HomeJopsView homeJopsView;

    public HomeJopsPresenter(Context context, HomeJopsView homeJopsView) {
        this.context = context;
        this.homeJopsView = homeJopsView;
    }

    public void getHomeJopsResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<HomeJopsResponse> call = service.getHomeJopsData(map );
        call.enqueue( new Callback<HomeJopsResponse>() {
            @Override
            public void onResponse(Call<HomeJopsResponse> call, Response<HomeJopsResponse> response) {
                if(response.isSuccessful()) {
                    homeJopsView.showHomeJopsList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HomeJopsResponse> call, Throwable t) {
                homeJopsView.showJopsError();
            }
        } );
    }
}

