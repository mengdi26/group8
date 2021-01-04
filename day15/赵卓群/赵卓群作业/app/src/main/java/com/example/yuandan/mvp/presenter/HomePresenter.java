package com.example.yuandan.mvp.presenter;

import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.model.MyModel;
import com.example.yuandan.mvp.model.bean.HomeBannerBean;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;
import com.example.yuandan.mvp.ui.fragment.HomeFragment;

public class HomePresenter extends BasePresenter {

    private final MyModel myModel;
    private final HomeFragment homeFragment;

    public HomePresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        myModel = new MyModel();
    }

    @Override
    public void start() {
       myModel.getHome(new MyPresenter() {
           @Override
           public void getData(Object o) {
               homeFragment.getData(o);
           }
       });

    }

    @Override
    public void start(Object[] t) {

    }
}
