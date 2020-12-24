package com.example.day06.di.component;

import com.example.day06.di.module.OKManager;
import com.example.day06.mvp.model.RxOpretorImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OKManager.class)
public interface OkComponent {
    void getSingleApiService(RxOpretorImpl impl);

}
