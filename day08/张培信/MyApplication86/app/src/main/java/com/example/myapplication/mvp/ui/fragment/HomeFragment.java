package com.example.myapplication.mvp.ui.fragment;

import android.util.Log;
import android.widget.TextView;


import com.baidu.mapapi.map.MapView;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.mvp.presenter.HomeFrgPresenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {



    @Override
    protected BasePresenter createPresenter() {
        return new HomeFrgPresenter(this);
    }

    @Override
    protected void initData() {
        getmPresenter().start();
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_fragment;
    }

    @Override
    public void onScuccess(Object obj) {
        String str = (String) obj;
        Log.e("TAG", str+"================");
    }


    @Override
    public void onError(String msg) {
        Log.e("TAG", msg+"================");
    }
}