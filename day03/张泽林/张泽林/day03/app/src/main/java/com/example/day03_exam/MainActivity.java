package com.example.day03_exam;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day03_exam.adpter.Vp1Adpter;
import com.example.day03_exam.fragment.AddFragment;
import com.example.day03_exam.fragment.FindFragment;
import com.example.day03_exam.fragment.HomeFragment;
import com.example.day03_exam.fragment.MyFragment;
import com.example.day03_exam.fragment.SofaFragment;
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
        fragments.add(new HomeFragment());
        fragments.add(new SofaFragment());
        fragments.add(new AddFragment());
        fragments.add(new FindFragment());
        fragments.add(new MyFragment());
        Vp1Adpter adpter = new Vp1Adpter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adpter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("首页").setIcon(R.drawable.icon_tab_home);
        tab.getTabAt(1).setText("沙发").setIcon(R.drawable.icon_tab_sofa);
        tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setText("发现").setIcon(R.drawable.icon_tab_find);
        tab.getTabAt(4).setText("我的").setIcon(R.drawable.icon_tab_mine);
    }
}