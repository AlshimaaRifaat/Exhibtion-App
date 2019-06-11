package com.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.exhibtion.R;
import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.CallUsResponse;
import com.exhibtion.model.NavigationServiceProviderResponse;
import com.exhibtion.view.CallUsView;
import com.exhibtion.view.NavigationServiceProviderView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NavigationServiceProviderPresenter {
    Context context;
    NavigationServiceProviderView navigationServiceProviderView;

    public NavigationServiceProviderPresenter(Context context, NavigationServiceProviderView navigationServiceProviderView) {
        this.context = context;
        this.navigationServiceProviderView = navigationServiceProviderView;
    }

    public void getNavigationServiceProviderResult(String Name, String Email, String Phone, String Msg, String Reason)
    {
        Map<String,String> map=new HashMap<>(  );
        {
            map.put( "name",Name );
            map.put("email",Email);
            map.put("phone", Phone);
            map.put( "message",Msg );
            map.put("reason",Reason);

            Service service= Client.getClient().create( Service.class );
            Call<NavigationServiceProviderResponse> call =service.getNavServiceProviderData(  map);
            call.enqueue( new Callback<NavigationServiceProviderResponse>() {
                @Override
                public void onResponse(Call<NavigationServiceProviderResponse> call, Response<NavigationServiceProviderResponse> response) {
                    if (response.isSuccessful())
                    {
                        navigationServiceProviderView.showNavServiceProviderData(response.body().getData());

                    }

                }

                @Override
                public void onFailure(Call<NavigationServiceProviderResponse> call, Throwable t) {
                    Toast.makeText( context, R.string.NoResultFound,
                            Toast.LENGTH_SHORT).show();
                }
            } );
        }
    }


}
