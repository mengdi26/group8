package com.example.day04_zy;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.day04_zy.fragment.CollectionFragment;
import com.example.day04_zy.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FrameLayout frame;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private int mposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment sfragment = fragments.get(position);
                Fragment hfragment = fragments.get(mposition);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (!sfragment.isAdded()){
                    transaction.add(R.id.frame,sfragment);
                }
                transaction .show(sfragment);
                transaction.hide(hfragment);
                transaction.commit();
                mposition = position;
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        frame = (FrameLayout) findViewById(R.id.frame);
        tab = (TabLayout) findViewById(R.id.tab);


        toolbar.setTitle("发现");
        toolbar.setTitleMargin(430,0,0,0);
        setSupportActionBar(toolbar);

        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.selector_o));
        tab.addTab(tab.newTab().setText("发现").setIcon(R.drawable.selector_q));
        tab.addTab(tab.newTab().setIcon(R.drawable.icon_tab_publish));
        tab.addTab(tab.newTab().setText("商城").setIcon(R.drawable.selector_w));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.selector_we));
        fragments = new ArrayList<>();
        fragments.add(new CollectionFragment());
        fragments.add(new HomeFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new CollectionFragment());
        fragments.add(new CollectionFragment());

        getSupportFragmentManager().beginTransaction().add(R.id.frame, fragments.get(0)).commit();
    }
}
