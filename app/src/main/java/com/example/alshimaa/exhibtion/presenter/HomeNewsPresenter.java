package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HomeServiceProviderResponse;
import com.exhibtion.model.NewsResponse;
import com.exhibtion.view.HomeNewsView;
import com.exhibtion.view.HomeServiceProviderView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeNewsPresenter {
    Context context;
    HomeNewsView homeNewsView;

    public HomeNewsPresenter(Context context, HomeNewsView homeNewsView) {
        this.context = context;
        this.homeNewsView = homeNewsView;
    }

    public void getHomeNewsResult(String Lang)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        Service service = Client.getClient().create( Service.class );
        Call<NewsResponse> call = service.getNewsData(map );
        call.enqueue( new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if(response.isSuccessful()) {
                    homeNewsView.showHomeNewsList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {

                homeNewsView.showError();
            }
        } );
    }
}

