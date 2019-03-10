package com.example.alshimaa.exhibtion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.alshimaa.exhibtion.activity.LoginActivity;
import com.example.alshimaa.exhibtion.activity.MainActivity;
import com.example.alshimaa.exhibtion.activity.NavigationActivity;
import com.example.alshimaa.exhibtion.activity.VisitorActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_splash );

        Thread timer=new Thread(  )
        {
            @Override
            public void run() {
                super.run();
                try {
                    sleep( 4000 );

                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }finally {

                        Intent intent=new Intent( SplashActivity.this,NavigationActivity.class);
                        startActivity( intent );
                    finish();
                }
            }
        };

        timer.start();

    }

}
