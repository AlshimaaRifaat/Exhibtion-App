package com.exhibtion.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.exhibtion.R;

public class MapActivity extends AppCompatActivity {
String LinkMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        LinkMap= getIntent().getStringExtra("link_map");
         WebView webview = (WebView)findViewById(R.id.webView);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.loadData( LinkMap , "text/html", "utf-8");
                WebSettings webViewSettings = webview.getSettings();
                webViewSettings.setJavaScriptCanOpenWindowsAutomatically(true);
                webViewSettings.setJavaScriptEnabled(true);
                webViewSettings.setBuiltInZoomControls(true);
                webViewSettings.setPluginState(WebSettings.PluginState.ON);
    }
}
