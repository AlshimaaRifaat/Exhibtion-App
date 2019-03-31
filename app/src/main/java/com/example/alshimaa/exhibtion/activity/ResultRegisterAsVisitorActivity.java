package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.alshimaa.exhibtion.R;
import com.example.alshimaa.exhibtion.adapter.HomeUnderConstructAdapter;
import com.example.alshimaa.exhibtion.adapter.ResultRegisterAsVisitorAdapter;
import com.example.alshimaa.exhibtion.fragment.DetailsExhibtionFragment;
import com.example.alshimaa.exhibtion.fragment.DetailsExhibtorsFragment;
import com.example.alshimaa.exhibtion.model.ResultRegisterAsVisitorData;
import com.example.alshimaa.exhibtion.presenter.ResultRegisterAsVisitorPresenter;
import com.example.alshimaa.exhibtion.view.ResultRegisterAsVisitorView;

import java.util.List;

public class ResultRegisterAsVisitorActivity extends AppCompatActivity implements ResultRegisterAsVisitorView{
    ResultRegisterAsVisitorPresenter resultRegisterAsVisitorPresenter;
    ResultRegisterAsVisitorAdapter resultRegisterAsVisitorAdapter;
    RecyclerView recyclerViewResRegisterAsVisitor;
    public static String Visibility;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_result_register_as_visitor);
        init();



        ResultRegisterAsVisitor();
    }

    private void init() {
        recyclerViewResRegisterAsVisitor=findViewById(R.id.Result_reg_visitor_recycler);
    }

    private void ResultRegisterAsVisitor() {
        resultRegisterAsVisitorPresenter=new ResultRegisterAsVisitorPresenter(this,this);
        if(RegisterActivity.RegisterFromCurExhib.equals("yes")) {
            resultRegisterAsVisitorPresenter.getResultRegisterAsVisitorResult(RegisterActivity.userNameEtext.getText().toString(),
                    RegisterActivity.userEmailEtext.getText().toString(), RegisterActivity.userPhoneEtext.getText().toString(), DetailsExhibtionFragment.ID); // fair id
        }else
        {
            resultRegisterAsVisitorPresenter.getResultRegisterAsVisitorResult(RegisterActivity.userNameEtext.getText().toString(),
                    RegisterActivity.userEmailEtext.getText().toString(), RegisterActivity.userPhoneEtext.getText().toString(), RegisterNowActivity.FairId);
        }
    }


    @Override
    public void showRegisterAsVisitorData(List<ResultRegisterAsVisitorData> registerAsVisitorDataList) {
        resultRegisterAsVisitorAdapter=new ResultRegisterAsVisitorAdapter( this,registerAsVisitorDataList );
       /* homeUnderConstructAdapter.onClick(this);*/
        /*homeUnderConstructAdapter.onClickItem(this);*/
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewResRegisterAsVisitor.setLayoutManager(linearLayoutManager);
        recyclerViewResRegisterAsVisitor.setAdapter( resultRegisterAsVisitorAdapter );
    }

    @Override
    public void showError() {

    }
}
