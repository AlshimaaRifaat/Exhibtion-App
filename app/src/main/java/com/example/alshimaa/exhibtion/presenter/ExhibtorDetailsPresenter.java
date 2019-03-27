package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.api.Client;
import com.example.alshimaa.exhibtion.api.Service;
import com.example.alshimaa.exhibtion.model.ExhibtorDetailsResponse;
import com.example.alshimaa.exhibtion.model.ExhibtorsResponse;
import com.example.alshimaa.exhibtion.view.ExhibtorDetailsListView;
import com.example.alshimaa.exhibtion.view.ExhibtorsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibtorDetailsPresenter {
    Context context;
    ExhibtorDetailsListView exhibtorDetailsListView;

    public ExhibtorDetailsPresenter(Context context, ExhibtorDetailsListView exhibtorDetailsListView) {
        this.context = context;
        this.exhibtorDetailsListView = exhibtorDetailsListView;
    }

    public void getExhibtorDetailsResult(String Lang, String Id_User)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_user",Id_User);
        Service service = Client.getClient().create( Service.class );
        Call<ExhibtorDetailsResponse> call = service.getExhibtorDetailsData(map );
        call.enqueue( new Callback<ExhibtorDetailsResponse>() {
            @Override
            public void onResponse(Call<ExhibtorDetailsResponse> call, Response<ExhibtorDetailsResponse> response) {
                if(response.isSuccessful()) {
                    exhibtorDetailsListView.showExhibtorDetailsListView(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<ExhibtorDetailsResponse> call, Throwable t) {
                exhibtorDetailsListView.showError();
            }
        } );
    }
}
