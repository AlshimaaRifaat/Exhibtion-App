package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.HallOneResponse;
import com.example.alshimaa.exhibtion.model.HallThreeResponse;
import com.example.alshimaa.exhibtion.view.HallOneView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HallThreePresenter {
    Context context;
    HallOneView hallOneView;

    public HallThreePresenter(Context context, HallOneView hallOneView) {
        this.context = context;
        this.hallOneView = hallOneView;
    }

    public void getHallThreeResult(String Id_fair )
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",Id_fair);
        Service service = Client.getClient().create( Service.class );
        Call<HallThreeResponse> call = service.getHallThreeData(map );
        call.enqueue( new Callback<HallThreeResponse>() {
            @Override
            public void onResponse(Call<HallThreeResponse> call, Response<HallThreeResponse> response) {
                if(response.isSuccessful()) {
                    hallOneView.showHallThreeList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HallThreeResponse> call, Throwable t) {
                hallOneView.showHallThreeError();
            }
        } );
    }

}

