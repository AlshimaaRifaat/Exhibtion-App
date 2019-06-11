package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.PreviousExhibtionResponse;
import com.exhibtion.model.PuthesResponse;
import com.exhibtion.view.PreviousExhibtionView;
import com.exhibtion.view.PuthesView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PuthesPresenter {
    Context context;
    PuthesView puthesView;

    public PuthesPresenter(Context context, PuthesView puthesView) {
        this.context = context;
        this.puthesView = puthesView;
    }

    public void getPuthesResult(String Id_Fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",Id_Fair);
        Service service = Client.getClient().create( Service.class );
        Call<PuthesResponse> call = service.getPuthesData(map );
        call.enqueue( new Callback<PuthesResponse>() {
            @Override
            public void onResponse(Call<PuthesResponse> call, Response<PuthesResponse> response) {
                if(response.isSuccessful()) {
                    puthesView.showPuthesList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PuthesResponse> call, Throwable t) {
                puthesView.showError();
            }
        } );
    }

}
