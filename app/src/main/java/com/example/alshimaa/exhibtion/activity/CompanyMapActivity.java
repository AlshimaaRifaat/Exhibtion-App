package com.example.alshimaa.exhibtion.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.exhibtion.R;


public class CompanyMapActivity extends AppCompatActivity {
    String CompanyMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_map);

            CompanyMap = getIntent().getStringExtra("company_map");
        if(CompanyMap!=null) {
           // Toast.makeText(this, CompanyMap, Toast.LENGTH_SHORT).show();
            WebView webview = (WebView) findViewById(R.id.webView_company);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadData(CompanyMap, "text/html", "utf-8");
            WebSettings webViewSettings = webview.getSettings();
            webViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
            webViewSettings.setJavaScriptEnabled(true);
            webViewSettings.setBuiltInZoomControls(true);
            webViewSettings.setPluginState(WebSettings.PluginState.ON);
        }
    }
}
