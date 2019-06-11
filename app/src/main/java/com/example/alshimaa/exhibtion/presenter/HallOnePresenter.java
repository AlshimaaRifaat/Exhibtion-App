package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.ExhibtorsResponse;
import com.exhibtion.model.HallOneResponse;
import com.exhibtion.view.ExhibtorsView;
import com.exhibtion.view.HallOneView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HallOnePresenter {
    Context context;
    HallOneView hallOneView;

    public HallOnePresenter(Context context, HallOneView hallOneView) {
        this.context = context;
        this.hallOneView = hallOneView;
    }

    public void getHallOneResult(String Id_fair )
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",Id_fair);
        Service service = Client.getClient().create( Service.class );
        Call<HallOneResponse> call = service.getHallOneData(map );
        call.enqueue( new Callback<HallOneResponse>() {
            @Override
            public void onResponse(Call<HallOneResponse> call, Response<HallOneResponse> response) {
                if(response.isSuccessful()) {
                    hallOneView.showHallOneList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HallOneResponse> call, Throwable t) {
                hallOneView.showError();
            }
        } );
    }

}

