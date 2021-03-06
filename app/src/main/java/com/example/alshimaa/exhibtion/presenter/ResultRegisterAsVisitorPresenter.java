package com.exhibtion.presenter;

import android.content.Context;
import android.widget.Toast;

import com.exhibtion.R;
import com.exhibtion.api.Client;
import com.exhibtion.api.Service;
import com.exhibtion.model.PuthesRegisterResponse;
import com.exhibtion.model.ResultRegisterAsVisitorResponse;
import com.exhibtion.view.PuthesRegisterView;
import com.exhibtion.view.ResultRegisterAsVisitorView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultRegisterAsVisitorPresenter {
    Context context;
    ResultRegisterAsVisitorView resultRegisterAsVisitorView;

    public ResultRegisterAsVisitorPresenter(Context context, ResultRegisterAsVisitorView resultRegisterAsVisitorView) {
        this.context = context;
        this.resultRegisterAsVisitorView = resultRegisterAsVisitorView;
    }

    public void getResultRegisterAsVisitorResult(String Name, String Email, String Phone, String Id_Fair)
    {
        Map<String,String> map=new HashMap<>(  );
        {
            map.put( "name",Name );
            map.put("email",Email);
            map.put("phone", Phone);
            map.put( "fairs_id",Id_Fair );


            Service service= Client.getClient().create( Service.class );
            Call<ResultRegisterAsVisitorResponse> call =service.getRegisterAsVisitorData(  map);
            call.enqueue( new Callback<ResultRegisterAsVisitorResponse>() {
                @Override
                public void onResponse(Call<ResultRegisterAsVisitorResponse> call, Response<ResultRegisterAsVisitorResponse> response) {
                    if (response.isSuccessful())
                    {
                        resultRegisterAsVisitorView.showRegisterAsVisitorData(response.body().getData());

                    }

                }

                @Override
                public void onFailure(Call<ResultRegisterAsVisitorResponse> call, Throwable t) {
                    Toast.makeText( context, R.string.NoResultFound,
                            Toast.LENGTH_SHORT).show();
                }
            } );
        }
    }
}