package com.example.day03;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.day03.fragment.FxFragment;
import com.example.day03.fragment.ScFragment;
import com.example.day03.fragment.SsFragment;
import com.example.day03.fragment.SyFragment;
import com.example.day03.fragment.WdFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mFlMain;
    private TabLayout mTabMain;
    private TextView mTvToolbar;
    private Toolbar mToolbar;
    private SyFragment syFragment;
    private FxFragment fxFragment;
    private SsFragment ssFragment;
    private ScFragment scFragment;
    private WdFragment wdFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mFlMain = (FrameLayout) findViewById(R.id.fl_main);
        mTabMain = (TabLayout) findViewById(R.id.tab_main);
        syFragment = new SyFragment();
        fxFragment = new FxFragment();
        ssFragment = new SsFragment();
        scFragment = new ScFragment();
        wdFragment = new WdFragment();
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(syFragment);
        fragments.add(fxFragment);
        fragments.add(ssFragment);
        fragments.add(scFragment);
        fragments.add(wdFragment);
        mTabMain.addTab(mTabMain.newTab().setText("首页").setIcon(R.drawable.icon_tab_home));
        mTabMain.addTab(mTabMain.newTab().setText("发现").setIcon(R.drawable.icon_tab_find));
        mTabMain.addTab(mTabMain.newTab().setText("").setIcon(R.drawable.icon_tab_publish));
        mTabMain.addTab(mTabMain.newTab().setText("商城").setIcon(R.drawable.icon_tab_sofa));
        mTabMain.addTab(mTabMain.newTab().setText("我的").setIcon(R.drawable.icon_tab_mine));
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_main, syFragment)
                .add(R.id.fl_main, fxFragment)
                .add(R.id.fl_main, ssFragment)
                .add(R.id.fl_main, scFragment)
                .add(R.id.fl_main, wdFragment)
                .show(syFragment)
                .hide(fxFragment)
                .hide(ssFragment)
                .hide(scFragment)
                .hide(wdFragment).commit();
        mTabMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                final int position = tab.getPosition();
                switch (position) {
                    case 0:

                        getSupportFragmentManager().beginTransaction()
                                .show(syFragment)
                                .hide(fxFragment)
                                .hide(ssFragment)
                                .hide(scFragment)
                                .hide(wdFragment).commit();
                        final TabLayout.Tab tabAt = mTabMain.getTabAt(0);
                        mTvToolbar.setText(tabAt.getText());
                        break;
                    case 1:

                        getSupportFragmentManager().beginTransaction()
                                .show(fxFragment)
                                .hide(syFragment)
                                .hide(ssFragment)
                                .hide(scFragment)
                                .hide(wdFragment).commit();
                        final TabLayout.Tab tabAt1 = mTabMain.getTabAt(1);
                        mTvToolbar.setText(tabAt1.getText());
                        break;
                    case 2:
                        final TabLayout.Tab tabAt2 = mTabMain.getTabAt(2);
                        mTvToolbar.setText(tabAt2.getText());
                        getSupportFragmentManager().beginTransaction()
                                .show(ssFragment)
                                .hide(fxFragment)
                                .hide(syFragment)
                                .hide(scFragment)
                                .hide(wdFragment).commit();
                        break;
                    case 3:
                        final TabLayout.Tab tabAt3 = mTabMain.getTabAt(3);
                        mTvToolbar.setText(tabAt3.getText());
                        getSupportFragmentManager().beginTransaction()
                                .show(scFragment)
                                .hide(fxFragment)
                                .hide(ssFragment)
                                .hide(syFragment)
                                .hide(wdFragment).commit();
                        break;
                    case 4:
                        final TabLayout.Tab tabAt4 = mTabMain.getTabAt(4);
                        mTvToolbar.setText(tabAt4.getText());
                        getSupportFragmentManager().beginTransaction()
                                .show(wdFragment)
                                .hide(fxFragment)
                                .hide(ssFragment)
                                .hide(scFragment)
                                .hide(syFragment).commit();
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

        mTvToolbar = (TextView) findViewById(R.id.tv_toolbar);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }
}
