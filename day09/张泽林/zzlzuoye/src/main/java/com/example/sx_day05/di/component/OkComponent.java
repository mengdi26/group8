package com.example.sx_day05.di.component;


import com.example.sx_day05.di.module.OKManager;
import com.example.sx_day05.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = OKManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}
