package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.SponsorResponse;
import com.exhibtion.view.OrganizersAndServiceProvidersView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SponsorPresenter {
    Context context;
    OrganizersAndServiceProvidersView organizersAndServiceProvidersView;

    public SponsorPresenter(Context context, OrganizersAndServiceProvidersView organizersAndServiceProvidersView) {
        this.context = context;
        this.organizersAndServiceProvidersView = organizersAndServiceProvidersView;
    }

    public void getSponsorList(String Lang, String Id_Fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_fair",Id_Fair);
        Service service = Client.getClient().create( Service.class );
        Call<SponsorResponse> call = service.getSponsorData(map );
        call.enqueue( new Callback<SponsorResponse>() {
            @Override
            public void onResponse(Call<SponsorResponse> call, Response<SponsorResponse> response) {
                if(response.isSuccessful()) {
                    organizersAndServiceProvidersView.showSponsorData(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<SponsorResponse> call, Throwable t) {

                organizersAndServiceProvidersView.showError();
            }
        } );
    }
}
