package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alshimaa.exhibtion.R;

public class RegisterInExhibtionActivity extends AppCompatActivity {
Button registerNowBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_in_exhibtion);
        init();
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterInExhibtionActivity.this,ConfirmRegisterNowActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        registerNowBtn=findViewById(R.id.register_in_exhibtion_btn_register);
    }
}
