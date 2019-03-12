package com.example.alshimaa.exhibtion.activity;

import android.app.Dialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.alshimaa.exhibtion.R;

public class RegisterNowActivity extends AppCompatActivity {
    Typeface customFontRegular;
    TextView titleTxt;
    Button exhibtorBtn,visitorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog dialog=new Dialog( this );
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable( false );
        setContentView(R.layout.activity_register_now);
        init();
        customFontRegular = Typeface.createFromAsset( getAssets(), "DroidKufi-Regular.ttf" );
        titleTxt.setTypeface( customFontRegular );
        exhibtorBtn.setTypeface(customFontRegular);
        visitorBtn.setTypeface(customFontRegular);
    }

    private void init() {
        titleTxt=findViewById(R.id.register_now_text_title);
        exhibtorBtn=findViewById(R.id.register_now_btn_exhibtor);
        visitorBtn=findViewById(R.id.register_now_btn_visitor);
    }
}
