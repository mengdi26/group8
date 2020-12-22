package com.example.demo4.ui.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.demo4.R;
import com.example.demo4.ui.fragment.SYFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

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
        final List<Fragment> list=new ArrayList<>();
        list.add(new SYFragment());
        list.add(new SYFragment());
        list.add(new SYFragment());
        list.add(new SYFragment());
        list.add(new SYFragment());
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
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setIcon(R.drawable.sele);
        tab.getTabAt(1).setIcon(R.drawable.sele2);
        tab.getTabAt(2).setIcon(R.drawable.icon_tab_publish);
        tab.getTabAt(3).setIcon(R.drawable.sele3);
        tab.getTabAt(4).setIcon(R.drawable.wd);
    }
}
