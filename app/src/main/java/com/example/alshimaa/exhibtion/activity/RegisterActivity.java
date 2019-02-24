package com.example.alshimaa.exhibtion.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alshimaa.exhibtion.R;

public class RegisterActivity extends AppCompatActivity {
Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(intent);
            }
        });
    }

    private void init() {
        registerBtn=findViewById(R.id.register_btn_register);
    }
}
