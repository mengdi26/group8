package com.example.day03;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day03.adapter.VpAdapter;
import com.example.day03.fragment.BlangFragment2;
import com.example.day03.fragment.BlankFragment;
import com.example.day03.fragment.FoundFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);
        //tab设置标题
        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("发现");
        titles.add("    ");
        titles.add("商城");
        titles.add("我的");
        //初始化fragment集合
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new FoundFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        //适配器
        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, titles);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setIcon(R.drawable.selector);
        mTab.getTabAt(1).setIcon(R.drawable.selector);
        mTab.getTabAt(2).setIcon(R.drawable.selector);
        mTab.getTabAt(3).setIcon(R.drawable.selector);
        mTab.getTabAt(4).setIcon(R.drawable.selector);


    }
}