package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HallOneResponse;
import com.exhibtion.model.HallTwoResponse;
import com.exhibtion.view.HallOneView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HallTwoPresenter {
    Context context;
    HallOneView hallOneView;

    public HallTwoPresenter(Context context, HallOneView hallOneView) {
        this.context = context;
        this.hallOneView = hallOneView;
    }

    public void getHallTwoResult(String Id_fair )
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",Id_fair);
        Service service = Client.getClient().create( Service.class );
        Call<HallTwoResponse> call = service.getHallTwoData(map );
        call.enqueue( new Callback<HallTwoResponse>() {
            @Override
            public void onResponse(Call<HallTwoResponse> call, Response<HallTwoResponse> response) {
                if(response.isSuccessful()) {
                    hallOneView.showHallTwoList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HallTwoResponse> call, Throwable t) {
                hallOneView.showError();
            }
        } );
    }

}

