package com.example.day03.presenter;

import com.example.day03.fragment.PaoFragment;
import com.example.day03.model.MainModel;
import com.example.day03.view.MainView;

public class MainPrsenter {
    private MainView mMainView;
    private final MainModel mMainModel;

    public MainPrsenter(MainView mainView) {
        mMainView = mainView;
        mMainModel = new MainModel();
    }

    public void getActivity() {
        mMainModel.getActiv(new Resultcallback() {
            @Override
            public void onSuccess(Object object) {
                mMainView.onSuccess(object);
            }
        });

    }

    public void getTab() {
        mMainModel.getTab(new Resultcallback() {
            @Override
            public void onSuccess(Object object) {
                mMainView.onSuccess(object);
            }
        });
    }

    public void getData(int type) {
        mMainModel.getType(type, new Resultcallback() {
            @Override
            public void onSuccess(Object object) {
                mMainView.onSuccess(object);
            }
        });
    }

    public void getb1() {
        mMainModel.getb1(new Resultcallback() {
            @Override
            public void onSuccess(Object object) {
                mMainView.onSuccess(object);
            }
        });
    }
}
