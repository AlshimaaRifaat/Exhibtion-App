package com.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.exhibtion.R;
import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.CurrentExhibtionResponse;
import com.exhibtion.model.DetailsNavItemServiceProvResponse;
import com.exhibtion.view.CurrentExhibtionView;
import com.exhibtion.view.DetailsNavItemServiceProvView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsNavItemServiceProvPresenter {
    Context context;
    DetailsNavItemServiceProvView detailsNavItemServiceProvView;

    public DetailsNavItemServiceProvPresenter(Context context, DetailsNavItemServiceProvView detailsNavItemServiceProvView) {
        this.context = context;
        this.detailsNavItemServiceProvView = detailsNavItemServiceProvView;
    }

    public void getDetailsNavItemServiceProvResult(String Lang,String Id)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id",Id);
        Service service = Client.getClient().create( Service.class );
        Call<DetailsNavItemServiceProvResponse> call = service.getDetailsNavItemServiceProvData(map );
        call.enqueue( new Callback<DetailsNavItemServiceProvResponse>() {
            @Override
            public void onResponse(Call<DetailsNavItemServiceProvResponse> call, Response<DetailsNavItemServiceProvResponse> response) {
                if(response.isSuccessful()) {
                    detailsNavItemServiceProvView.showDetailsNavItemServiceProvList(response.body().getData());
                }else if(response.code()==404)
                {
                    Toast.makeText(context,  "No Result Found" ,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DetailsNavItemServiceProvResponse> call, Throwable t) {
                detailsNavItemServiceProvView.showError();

            }
        } );
    }
}
