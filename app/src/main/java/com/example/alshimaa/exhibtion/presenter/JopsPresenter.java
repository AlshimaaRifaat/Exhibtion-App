package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.AboutUsResponse;
import com.exhibtion.model.JopsResponse;
import com.exhibtion.view.AboutUsView;
import com.exhibtion.view.JopsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JopsPresenter {
    Context context;
    JopsView jopsView;

    public JopsPresenter(Context context, JopsView jopsView) {
        this.context = context;
        this.jopsView = jopsView;
    }

    public void getJopsResult(String Lang ,String Fair_Id,String User_Id)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("fairs_id",Fair_Id);
        map.put("id_user",User_Id);
        Service service = Client.getClient().create( Service.class );
        Call<JopsResponse> call = service.getJopsData(map );
        call.enqueue( new Callback<JopsResponse>() {
            @Override
            public void onResponse(Call<JopsResponse> call, Response<JopsResponse> response) {
                if(response.isSuccessful()) {
                    jopsView.showJopsList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<JopsResponse> call, Throwable t) {
                jopsView.showError();
            }
        } );
    }
}
