package com.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.exhibtion.R;
import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.CallUsResponse;
import com.exhibtion.view.CallUsView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallUsPresenter {
    Context context;
    CallUsView callUsView;

    public CallUsPresenter(Context context, CallUsView callUsView) {
        this.context = context;
        this.callUsView = callUsView;
    }

    public void getCallUsResult(String Name,String Email,String Phone,String Msg,String Reason)
    {
        Map<String,String> map=new HashMap<>(  );
        {
            map.put( "name",Name );
            map.put("email",Email);
            map.put("phone", Phone);
            map.put( "message",Msg );
            map.put("reason",Reason);

            Service service= Client.getClient().create( Service.class );
            Call<CallUsResponse> call =service.getCallUsData(  map);
            call.enqueue( new Callback<CallUsResponse>() {
                @Override
                public void onResponse(Call<CallUsResponse> call, Response<CallUsResponse> response) {
                    if (response.isSuccessful())
                    {
                     callUsView.showCallUsData(response.body().getData());

                    }

                }

                @Override
                public void onFailure(Call<CallUsResponse> call, Throwable t) {
                    Toast.makeText( context, R.string.NoResultFound,
                            Toast.LENGTH_SHORT).show();
                }
            } );
        }
    }
}
