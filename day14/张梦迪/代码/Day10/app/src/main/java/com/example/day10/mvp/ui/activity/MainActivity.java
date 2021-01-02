package com.example.day10.mvp.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.day10.R;
import com.example.day10.base.BaseActivity;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.presenter.MainActPresenter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_main_act)
    FrameLayout flMainAct;
    @BindView(R.id.tab_main_act)
    TabLayout tabMainAct;

    @Override
    protected BasePresenter createPresenter() {
        return new MainActPresenter(this);
    }

    @Override
    protected void initData() {
        createPresenter().start(flMainAct,tabMainAct);
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void getData(Object o) {

    }
}