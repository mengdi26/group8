package com.example.yuandan.mvp.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.yuandan.R;
import com.example.yuandan.base.BaseActivity;
import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.presenter.MainActPresenter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_home)
    ImageView ivHome;

    @Override
    protected BasePresenter createPresenter() {
        return new MainActPresenter(this);
    }

    @Override
    protected void initData() {
        createPresenter().start(flMain, tabMain,tvHome,ivHome);
    }

    @Override
    protected void init() {
        setSupportActionBar(toolbar);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}