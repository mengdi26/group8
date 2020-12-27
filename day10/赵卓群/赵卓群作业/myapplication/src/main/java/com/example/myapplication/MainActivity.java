package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.fragment.BlankFragment1;
import com.example.myapplication.fragment.BlankFragment2;
import com.example.myapplication.fragment.BlankFragment3;
import com.example.myapplication.fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment1());
        fragments.add(new BlankFragment2());
        fragments.add(new BlankFragment3());
        fragments.add(new BlankFragment4());
        Adpter adpter = new Adpter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adpter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("地图1");
        tab.getTabAt(1).setText("地图2");
        tab.getTabAt(2).setText("地图3");
        tab.getTabAt(3).setText("地图4");
    }
}
