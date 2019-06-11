package com.exhibtion.presenter;

import android.content.Context;


import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.CurrentExhibtionResponse;
import com.exhibtion.view.SearchHomeView;


import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchHomePresenter {
    Context context;
    SearchHomeView searchHomeView;

    public SearchHomePresenter(Context context, SearchHomeView searchHomeView) {
        this.context = context;
        this.searchHomeView = searchHomeView;
    }

    public void getSearchHomeExhibtionResult(String Lang, String Key)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("key",Key);
        Service service = Client.getClient().create( Service.class );
        Call<CurrentExhibtionResponse> call = service.getSearchHomeData(map );
        call.enqueue( new Callback<CurrentExhibtionResponse>() {
            @Override
            public void onResponse(Call<CurrentExhibtionResponse> call, Response<CurrentExhibtionResponse> response) {
                if(response.isSuccessful()) {
                    searchHomeView.showSearchHomeExhibtionList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<CurrentExhibtionResponse> call, Throwable t) {
                searchHomeView.showErrorHomeSearch("No data Found");
            }
        } );
    }
}
