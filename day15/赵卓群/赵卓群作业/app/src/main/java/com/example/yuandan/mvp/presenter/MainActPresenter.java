package com.example.yuandan.mvp.presenter;


import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;

import com.example.yuandan.R;
import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.ui.activity.MainActivity;
import com.example.yuandan.mvp.ui.fragment.BlankFragment;
import com.example.yuandan.mvp.ui.fragment.BlankFragment2;
import com.example.yuandan.mvp.ui.fragment.BlankFragment3;
import com.example.yuandan.mvp.ui.fragment.BlankFragment4;
import com.google.android.material.tabs.TabLayout;

public class MainActPresenter extends BasePresenter {


    private final MainActivity mainActivity;
    private BlankFragment blankFragment1;
    private BlankFragment2 blankFragment2;
    private BlankFragment3 blankFragment3;
    private BlankFragment4 blankFragment4;

    public MainActPresenter(MainActivity mainActivity) {
        super();
        this.mainActivity = mainActivity;
    }

    @Override
    public void start() {

    }

    @Override
    public void start(Object[] t) {
        FrameLayout frameLayout = (FrameLayout) t[0];
        TabLayout tabLayout = (TabLayout) t[1];
        TextView tv_home = (TextView) t[2];
        ImageView iv_home = (ImageView) t[3];

        blankFragment1 = new BlankFragment();
        blankFragment2 = new BlankFragment2();
        blankFragment3 = new BlankFragment3();
        blankFragment4 = new BlankFragment4();

        FragmentManager supportFragmentManager = mainActivity.getSupportFragmentManager();
        supportFragmentManager.beginTransaction()
                .add(R.id.fl_main,blankFragment1)
                .add(R.id.fl_main,blankFragment2)
                .add(R.id.fl_main,blankFragment3)
                .add(R.id.fl_main,blankFragment4)
                .hide(blankFragment2)
                .hide(blankFragment3)
                .hide(blankFragment4)
                .commit();


        tabLayout.addTab(tabLayout.newTab().setText("首页").setIcon(R.drawable.tab_0));
        tabLayout.addTab(tabLayout.newTab().setText("备课").setIcon(R.drawable.tab_1));
        tabLayout.addTab(tabLayout.newTab().setText("学习").setIcon(R.drawable.tab_2));
        tabLayout.addTab(tabLayout.newTab().setText("我的").setIcon(R.drawable.tab_3));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment1)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        iv_home.setImageResource(R.drawable.shangla);
                        break;

                    case 1:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .commit();
                        mainActivity.setTitle("备课");
                        iv_home.setImageResource(R.drawable.yuan);
                        break;

                    case 2:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment3)
                                .hide(blankFragment2)
                                .hide(blankFragment1)
                                .hide(blankFragment4)
                                .commit();
                        mainActivity.setTitle("我的学习");
                        iv_home.setImageResource(R.drawable.yuan);
                        break;

                    case 3:
                        supportFragmentManager.beginTransaction()
                                .show(blankFragment4)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment1)
                                .commit();
                        mainActivity.setTitle("");
                        iv_home.setImageResource(R.drawable.yuan);
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
