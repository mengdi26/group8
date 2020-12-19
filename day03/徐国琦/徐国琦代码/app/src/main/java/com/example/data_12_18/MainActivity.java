package com.example.data_12_18;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.data_12_18.Fragment.CallFragment;
import com.example.data_12_18.Fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tl = (TabLayout) findViewById(R.id.tl);
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        list.add(new HomeFragment());
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setText("首页").setIcon(R.drawable.aaa);
        tl.getTabAt(1).setText("发现").setIcon(R.drawable.bbb);
        tl.getTabAt(2).setIcon(R.drawable.ccc);
        tl.getTabAt(3).setText("商城").setIcon(R.drawable.ddd);
        tl.getTabAt(4).setText("我的").setIcon(R.drawable.eee);
    }
}