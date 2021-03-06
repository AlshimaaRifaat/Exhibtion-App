package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.EShopResponse;
import com.exhibtion.model.ServicesProvidedResponse;
import com.exhibtion.view.EShopView;
import com.exhibtion.view.ServicesProvidedView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EShopPresenter {
    Context context;
    EShopView eShopView;

    public EShopPresenter(Context context, EShopView eShopView) {
        this.context = context;
        this.eShopView = eShopView;
    }

    public void getEShopResult(String Lang, String Fairs_Id, String Id_user)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("fairs_id",Fairs_Id);
        map.put("id_user",Id_user);
        Service service = Client.getClient().create( Service.class );
        Call<EShopResponse> call = service.getEShopData(map );
        call.enqueue( new Callback<EShopResponse>() {
            @Override
            public void onResponse(Call<EShopResponse> call, Response<EShopResponse> response) {
                if(response.isSuccessful()) {
                    eShopView.showEshopDataList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<EShopResponse> call, Throwable t) {
                eShopView.showError();
            }
        } );
    }
}
