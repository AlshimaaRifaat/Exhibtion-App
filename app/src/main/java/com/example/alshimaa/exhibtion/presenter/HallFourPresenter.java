package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HallFourResponse;
import com.exhibtion.model.HallTwoResponse;
import com.exhibtion.view.HallOneView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HallFourPresenter {
    Context context;
    HallOneView hallOneView;

    public HallFourPresenter(Context context, HallOneView hallOneView) {
        this.context = context;
        this.hallOneView = hallOneView;
    }

    public void getHallFourResult(String Id_fair )
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",Id_fair);
        Service service = Client.getClient().create( Service.class );
        Call<HallFourResponse> call = service.getHallFourData(map );
        call.enqueue( new Callback<HallFourResponse>() {
            @Override
            public void onResponse(Call<HallFourResponse> call, Response<HallFourResponse> response) {
                if(response.isSuccessful()) {
                    hallOneView.showHallFourList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<HallFourResponse> call, Throwable t) {
                hallOneView.showError();
            }
        } );
    }

}


