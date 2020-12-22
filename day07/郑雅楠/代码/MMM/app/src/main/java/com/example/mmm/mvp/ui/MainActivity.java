package com.example.mmm.mvp.ui;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mmm.R;
import com.example.mmm.base.BaseActivity;
import com.example.mmm.base.BasePresenter;
import com.example.mmm.mvp.adapter.VpAdapter;
import com.example.mmm.mvp.fragment.BlankFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        //初始化标题集合
        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("首页");
        titles.add("首页");
        titles.add("首页");
        titles.add("首页");
        //初始化fr

        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fragments.add(new BlankFragment());
        }
        //适配器
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, titles);
        vp.setAdapter(vpAdapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.a);
        tab.getTabAt(1).setIcon(R.drawable.a);
        tab.getTabAt(2).setIcon(R.drawable.a);
        tab.getTabAt(3).setIcon(R.drawable.a);
        tab.getTabAt(4).setIcon(R.drawable.a);
    }

    @Override
    protected BasePresenter creataPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}