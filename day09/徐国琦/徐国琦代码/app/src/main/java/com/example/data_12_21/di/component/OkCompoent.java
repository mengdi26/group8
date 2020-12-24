package com.example.data_12_21.di.component;


import com.example.data_12_21.mvp.model.OKManager;
import com.example.data_12_21.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OKManager.class)
public interface OkCompoent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}
