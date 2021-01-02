package com.example.day10.mvp.presenter;

import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;

import com.example.day10.R;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.MyModel;
import com.example.day10.mvp.ui.activity.MainActivity;
import com.example.day10.mvp.ui.fragment.BlankFragment;
import com.example.day10.mvp.ui.fragment.BlankFragment2;
import com.example.day10.mvp.ui.fragment.BlankFragment3;
import com.example.day10.mvp.ui.fragment.BlankFragment4;
import com.example.day10.mvp.ui.fragment.BlankFragment5;
import com.google.android.material.tabs.TabLayout;

public class MainActPresenter extends BasePresenter {


    private final MainActivity mainActivity;
    private final MyModel myModel;

    public MainActPresenter(MainActivity mainActivity) {
        super();

        this.mainActivity = mainActivity;
        myModel = new MyModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void start(Object[] t) {
        setLayout(t);
    }

    private void setLayout(Object[] t) {
        FrameLayout lf_main = (FrameLayout) t[0];
        TabLayout tab_main = (TabLayout) t[1];

        mainActivity.setTitle("首页");


        BlankFragment blankFragment = new BlankFragment();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        BlankFragment3 blankFragment3 = new BlankFragment3();
        BlankFragment4 blankFragment4 = new BlankFragment4();
        BlankFragment5 blankFragment5 = new BlankFragment5();

        FragmentManager manager = mainActivity.getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fl_main_act,blankFragment)
                .add(R.id.fl_main_act,blankFragment2)
                .add(R.id.fl_main_act,blankFragment3)
                .add(R.id.fl_main_act,blankFragment4)
                .add(R.id.fl_main_act,blankFragment5)
                .hide(blankFragment)
                .hide(blankFragment2)
                .hide(blankFragment4)
                .hide(blankFragment5)
                .commit();

        tab_main.addTab(tab_main.newTab().setText("查看"));
        tab_main.addTab(tab_main.newTab().setText("详情"));
        tab_main.addTab(tab_main.newTab().setText("首页"));
        tab_main.addTab(tab_main.newTab().setText("收藏"));
        tab_main.addTab(tab_main.newTab().setText("位置"));

        tab_main.getTabAt(2).select();

        tab_main.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainActivity.setTitle(tab.getText());

                switch (tab.getPosition()) {
                    case 0:
                        manager.beginTransaction()
                                .show(blankFragment)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 1:
                        manager.beginTransaction()
                                .show(blankFragment2)
                                .hide(blankFragment)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 2:
                        manager.beginTransaction()
                                .show(blankFragment3)
                                .hide(blankFragment2)
                                .hide(blankFragment)
                                .hide(blankFragment4)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 3:
                        manager.beginTransaction()
                                .show(blankFragment4)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment)
                                .hide(blankFragment5)
                                .commit();
                        break;
                    case 4:
                        manager.beginTransaction()
                                .show(blankFragment5)
                                .hide(blankFragment2)
                                .hide(blankFragment3)
                                .hide(blankFragment4)
                                .hide(blankFragment)
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
