package com.example.myapplication.di.component;



import com.example.myapplication.di.module.OKManager;
import com.example.myapplication.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

//注射器
@Singleton
@Component(modules = OKManager.class)
public interface OkComponent {
    //自定义的方法
    void getSingleApiService(RxOpretorImpl impl);
}