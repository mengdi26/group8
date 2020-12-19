package com.example.day04;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import com.example.day04.fragment.AddFragment;
import com.example.day04.fragment.FindFragment;
import com.example.day04.fragment.HomeFragment;
import com.example.day04.fragment.MyFragment;
import com.example.day04.fragment.ShopFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout vp;
    private TabLayout tab;
    private MyFragment myFragment;
    private ShopFragment shopFragment;
    private AddFragment addFragment;
    private FindFragment findFragment;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        vp = (FrameLayout) findViewById(R.id.vp);
        tab = (TabLayout) findViewById(R.id.tab);
        homeFragment = new HomeFragment();
        findFragment = new FindFragment();
        addFragment = new AddFragment();
        shopFragment = new ShopFragment();
        myFragment = new MyFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.vp, homeFragment)
                .commit();
        tab.addTab(tab.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        tab.addTab(tab.newTab().setText("发现").setIcon(R.drawable.icon_tab_sofa));
        tab.addTab(tab.newTab().setText("").setIcon(R.drawable.icon_tab_publish));
        tab.addTab(tab.newTab().setText("商城").setIcon(R.drawable.icon_tab_find));
        tab.addTab(tab.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));

        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position){
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.vp, homeFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.vp, findFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.vp, addFragment)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.vp, shopFragment)
                                .commit();
                        break;
                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.vp, myFragment)
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
}