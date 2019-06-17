package com.example.alshimaa.exhibtion.presenter;

import android.content.Context;

import com.example.alshimaa.exhibtion.view.ExhibtionDiagramView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibtionDiagramPresenter {
    Context context;
   ExhibtionDiagramView exhibtionDiagramView;

    public ExhibtionDiagramPresenter(Context context, ExhibtionDiagramView exhibtionDiagramView) {
        this.context = context;
        this.exhibtionDiagramView = exhibtionDiagramView;
    }

    public void getExhibtionDiagramResult(String id_fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("id_fair",id_fair);
        com.exhibtion.api.Service service = com.exhibtion.api.Client.getClient().create( com.exhibtion.api.Service.class );
        Call<com.example.exhibtion.model.ExhibtionDiagramResponse> call = service.getExhibtionDiagramData(map );
        call.enqueue( new Callback<com.example.exhibtion.model.ExhibtionDiagramResponse>() {
            @Override
            public void onResponse(Call<com.example.exhibtion.model.ExhibtionDiagramResponse> call, Response<com.example.exhibtion.model.ExhibtionDiagramResponse> response) {
                if(response.isSuccessful()) {
                    exhibtionDiagramView.showExhibtionDiagramList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<com.example.exhibtion.model.ExhibtionDiagramResponse> call, Throwable t) {
                exhibtionDiagramView.showExhibtionDiagramError();
            }
        } );
    }
}
