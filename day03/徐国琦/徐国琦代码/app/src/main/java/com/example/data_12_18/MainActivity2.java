package com.example.data_12_18;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.data_12_18.Fragment.JyFragment;
import com.example.data_12_18.Fragment.QdFragement;
import com.example.data_12_18.Fragment.ThFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private Toolbar tool;
    private TabLayout tl;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        tl = (TabLayout) findViewById(R.id.tl);
        vp = (ViewPager) findViewById(R.id.vp);
        List<Fragment> list = new ArrayList<>();
        list.add(new JyFragment());
        list.add(new ThFragment());
        list.add(new QdFragement());
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
        tl.getTabAt(0).setText("经验榜");
        tl.getTabAt(1).setText("土豪榜");
        tl.getTabAt(2).setText("签到榜");
    }
}