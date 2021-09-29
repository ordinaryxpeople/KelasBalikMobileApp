package com.example.kelasbalikmobileapp;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.net.http.*;
import android.widget.Toast;

import com.example.kelasbalikmobileapp.FileDownloader.FileDownloader;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

public class ReadWebview extends AppCompatActivity {

    Activity activity ;
    private ProgressDialog progDailog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_webview);



        activity = this;

        progDailog = ProgressDialog.show(this, "Loading","Please wait...", true);
        progDailog.setCancelable(false);

        String url = getIntent().getStringExtra("url_pdf");
        WebView webView = findViewById(R.id.wvPdf);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.loadUrl(url);
                    }
                }, 1000);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });
        webView.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        }, 1000);

    }

    //    @Override
//    public void onBackPressed() {
//        Bundle extras = getIntent().getExtras();
//
//        if(extras != null){
//            if(extras.containsKey("url_pdf"))
//            {
//                getIntent().removeExtra("url_pdf");
//                Intent intent = new Intent(this,MainActivity.class);
//                startActivity(intent);
//            }
//        }
//    }
}