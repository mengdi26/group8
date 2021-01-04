package com.example.yuandan.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yuandan.App;
import com.example.yuandan.R;
import com.example.yuandan.base.BaseActivity;
import com.example.yuandan.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.iv_welcome)
    ImageView ivWelcome;
    private Handler handler = new Handler();
    private boolean ok;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        if (!ok) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(WelcomeActivity.this, VwvActivity.class));
                    finish();
                }
            }, 2000);
        }
    }

    @Override
    protected void init() {

        ok = App.getSP("ok", false);
        if (ok){
            startActivity(new Intent(WelcomeActivity.this,SelectActivity.class));
            finish();
        }

        Glide.with(this).load(R.drawable.welcome_img).into(ivWelcome);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

}