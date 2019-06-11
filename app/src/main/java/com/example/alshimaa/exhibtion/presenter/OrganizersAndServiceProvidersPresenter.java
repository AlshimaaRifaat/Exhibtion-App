package com.exhibtion.presenter;

import android.content.Context;

import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.HomeServiceProviderResponse;
import com.exhibtion.model.OrganizersAndServiceProvidersResponse;
import com.exhibtion.model.SponsorResponse;
import com.exhibtion.view.HomeServiceProviderView;
import com.exhibtion.view.OrganizersAndServiceProvidersView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizersAndServiceProvidersPresenter {
    Context context;
    OrganizersAndServiceProvidersView organizersAndServiceProvidersView;


    public OrganizersAndServiceProvidersPresenter(Context context, OrganizersAndServiceProvidersView organizersAndServiceProvidersView) {
        this.context = context;
        this.organizersAndServiceProvidersView = organizersAndServiceProvidersView;
    }

    public void getOrganizersAndServiceProvidersResult(String Lang,String Id_Fair)
    {
        Map<String,String> map=new HashMap<>();
        map.put("lang",Lang);
        map.put("id_fair",Id_Fair);
        Service service = Client.getClient().create( Service.class );
        Call<OrganizersAndServiceProvidersResponse> call = service.getOrganizersAndServiceProvidersData(map );
        call.enqueue( new Callback<OrganizersAndServiceProvidersResponse>() {
            @Override
            public void onResponse(Call<OrganizersAndServiceProvidersResponse> call, Response<OrganizersAndServiceProvidersResponse> response) {
                if(response.isSuccessful()) {
                    organizersAndServiceProvidersView.showOrganizersAndServiceProvidersList(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<OrganizersAndServiceProvidersResponse> call, Throwable t) {

                organizersAndServiceProvidersView.showError();
            }
        } );
    }

}
