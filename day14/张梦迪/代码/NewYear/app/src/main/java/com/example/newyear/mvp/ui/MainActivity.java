package com.example.newyear.mvp.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.newyear.Base.BaseActivity;
import com.example.newyear.Base.BasePresenter;
import com.example.newyear.R;
import com.example.newyear.mvp.ui.fragment.FirstPageFragment;
import com.example.newyear.mvp.ui.fragment.OtherFragment;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.toor)
    Toolbar mToor;
    @BindView(R.id.frame)
    FrameLayout mFrame;
    @BindView(R.id.tab)
    TabLayout mTab;
    private FirstPageFragment mFirstPageFragment;
    private OtherFragment mOtherFragment;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        mToor.setTitle("");
        mToor.setNavigationIcon(R.drawable.ic_baseline_local_florist_24);
        setSupportActionBar(mToor);

        mTab.addTab(mTab.newTab().setText("首页").setIcon(R.drawable.a3));
        mTab.addTab(mTab.newTab().setText("选课").setIcon(R.drawable.cccc));
        mTab.addTab(mTab.newTab().setText("学习").setIcon(R.drawable.learn));
        mTab.addTab(mTab.newTab().setText("我的").setIcon(R.drawable.person));
      //初始化fragment
        mFirstPageFragment = new FirstPageFragment();
        mOtherFragment = new OtherFragment();
        getSupportFragmentManager().beginTransaction()
      .replace(R.id.frame,mFirstPageFragment)
      .commit();
      //设置监听
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,mFirstPageFragment)
                                .commit();
                        break;
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,mOtherFragment)
                                .commit();
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,mOtherFragment)
                                .commit();
                        break;
                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frame,mOtherFragment)
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
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lay_menu,menu);
        return super.onCreateOptionsMenu(menu);

    }


    @OnClick({R.id.toor, R.id.frame, R.id.tab})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.toor:
                break;
            case R.id.frame:
                break;
            case R.id.tab:
                break;
        }
    }
}