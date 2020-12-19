package com.example.day04;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);

        mTab.addTab(mTab.newTab().setText("地址").setIcon(R.mipmap.address));
        mTab.addTab(mTab.newTab().setText("商城").setIcon(R.mipmap.shop));
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.mipmap.frist));
        mTab.addTab(mTab.newTab().setText("订单").setIcon(R.mipmap.ding));
    }
}