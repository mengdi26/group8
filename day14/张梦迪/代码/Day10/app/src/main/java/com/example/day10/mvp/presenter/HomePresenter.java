package com.example.day10.mvp.presenter;

import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.MyModel;
import com.example.day10.mvp.model.bean.ItemBean;
import com.example.day10.mvp.ui.fragment.HomeFragment;

public class HomePresenter extends BasePresenter {
    private final HomeFragment homeFragment;
    private final MyModel myModel;

    public HomePresenter(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        myModel = new MyModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void start(Object[] t) {
        int id = (int) t[0];
        myModel.getItem(id, new MyPresenter<ItemBean>() {
            @Override
            public void getData(ItemBean itemBean) {
                homeFragment.getData(itemBean);
            }
        });
    }
}
