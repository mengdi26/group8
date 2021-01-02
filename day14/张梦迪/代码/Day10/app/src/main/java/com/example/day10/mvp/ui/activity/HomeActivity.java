package com.example.day10.mvp.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.day10.R;
import com.example.day10.base.BaseActivity;
import com.example.day10.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {


    @BindView(R.id.web)
    WebView web;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void init() {

        setTitle("详情");

        String url = getIntent().getStringExtra("url");
        web.getSettings().setJavaScriptEnabled(true);

        web.loadUrl(url);

        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                web.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void getData(Object o) {

    }

}