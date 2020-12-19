package com.example.day05_2;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day05_2.bean.Info;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRel;
    private adpater mAdpater;
    private TabLayout mTab;
    private ImageView mImg11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mRel = (RecyclerView) findViewById(R.id.rel);
        //初始化集合
        ArrayList<Info> infos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            infos.add(new Info("郑雅楠", R.mipmap.ic_launcher));
        }
        //布局管理器
        mRel.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.HORIZONTAL, false));
        //适配器
        mAdpater = new adpater(infos, this);
        mRel.setAdapter(mAdpater);
        mTab = (TabLayout) findViewById(R.id.tab);
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.selector));
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.selector));
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.selector));
        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.selector));
        mImg11 = (ImageView) findViewById(R.id.img_11);
    }
}
