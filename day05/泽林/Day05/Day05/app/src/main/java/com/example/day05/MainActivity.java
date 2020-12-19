package com.example.day05;

import android.os.Bundle;
import android.view.Menu;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.day05.fragment.GonglFragment;
import com.example.day05.fragment.HomeFragment;
import com.example.day05.fragment.MyFragment;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tab;
    private FrameLayout fl_main;
    private MyFragment myFragment;
    private GonglFragment gonglFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("首页");
        toolbar.setTitleMargin(400, 0, 0, 0);
        setSupportActionBar(toolbar);
        tab = (TabLayout) findViewById(R.id.tab);
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        homeFragment = new HomeFragment();
        gonglFragment = new GonglFragment();
        myFragment = new MyFragment();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        tab.addTab(tab.newTab().setText("攻略").setIcon(R.drawable.icon_tab_movie));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_main,homeFragment)
                .commit();
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_main,homeFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_main,gonglFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fl_main,myFragment)
                                .commit();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}