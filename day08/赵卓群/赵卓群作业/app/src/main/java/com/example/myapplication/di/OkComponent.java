package com.example.myapplication.di;

import com.example.myapplication.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OkManage.class)
public interface OkComponent {
    void getSingleApiService(RxOpretorImpl impl);
}
