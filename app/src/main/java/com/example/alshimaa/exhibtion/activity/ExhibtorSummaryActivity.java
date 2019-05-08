package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.R;

public class ExhibtorSummaryActivity extends AppCompatActivity {
String Summary;
TextView summaryTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_exhibtor_summary);
        init();
       Summary= getIntent().getStringExtra("nabza");
     summaryTxt.setText(Summary);
    }

    private void init() {
        summaryTxt=findViewById(R.id.exhibtor_summary_desc);
    }
}
