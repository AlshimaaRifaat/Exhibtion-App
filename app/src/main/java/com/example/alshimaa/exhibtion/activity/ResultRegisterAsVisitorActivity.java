package com.exhibtion.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.widget.Toast;

import com.exhibtion.R;
import com.exhibtion.adapter.HomeUnderConstructAdapter;
import com.exhibtion.adapter.ResultRegisterAsVisitorAdapter;
import com.exhibtion.fragment.DetailsExhibtionFragment;
import com.exhibtion.fragment.DetailsExhibtorsFragment;
import com.exhibtion.model.ResultRegisterAsVisitorData;
import com.exhibtion.presenter.ResultRegisterAsVisitorPresenter;
import com.exhibtion.view.ResultRegisterAsVisitorView;

import java.util.List;

public class ResultRegisterAsVisitorActivity extends AppCompatActivity implements ResultRegisterAsVisitorView{
    ResultRegisterAsVisitorPresenter resultRegisterAsVisitorPresenter;
    ResultRegisterAsVisitorAdapter resultRegisterAsVisitorAdapter;
    RecyclerView recyclerViewResRegisterAsVisitor;
    public static String Visibility,Under,FromCur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_result_register_as_visitor);
        init();

       //Under = getIntent().getStringExtra("no_under");
        FromCur= getIntent().getStringExtra("registerFromCurExhib");

       // Toast.makeText(this, " CUR "+FromCur, Toast.LENGTH_SHORT).show();

        ResultRegisterAsVisitor();
    }

    private void init() {
        recyclerViewResRegisterAsVisitor=findViewById(R.id.Result_reg_visitor_recycler);
    }

    private void ResultRegisterAsVisitor() {
        resultRegisterAsVisitorPresenter=new ResultRegisterAsVisitorPresenter(this,this);

        if(DetailsExhibtionFragment.Visiblity.equals("yes")) {
            resultRegisterAsVisitorPresenter.getResultRegisterAsVisitorResult(RegisterActivity.userNameEtext.getText().toString(),
                    RegisterActivity.userEmailEtext.getText().toString(), RegisterActivity.userPhoneEtext.getText().toString(), DetailsExhibtionFragment.ID); // fair id
        }
        else
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
