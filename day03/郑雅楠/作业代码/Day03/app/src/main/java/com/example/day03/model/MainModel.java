package com.example.day03.model;

import android.util.Log;

import com.example.day03.bean.Info_Activity;
import com.example.day03.bean.Info_Navgation;
import com.example.day03.bean.Info_Type;
import com.example.day03.bean.bang_1;
import com.example.day03.net.ApiService;
import com.example.day03.presenter.Resultcallback;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel {
    public void getActiv(final Resultcallback resultcallback) {
        new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
                .build()
                .create(ApiService.class)
                .getActici()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Info_Activity>() {
                    @Override
                    public void onNext(Info_Activity info_activity) {
                        resultcallback.onSuccess(info_activity);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("MAG", "T :" + t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getTab(final Resultcallback resultcallback) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getNav()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Info_Navgation>() {
                    @Override
                    public void onNext(Info_Navgation info_navgation) {
                        resultcallback.onSuccess(info_navgation);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getType(int type, final Resultcallback resultcallback) {
        new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.url)
                .build()
                .create(ApiService.class)
                .getType(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Info_Type>() {
                    @Override
                    public void onNext(Info_Type info_type) {
                        resultcallback.onSuccess(info_type);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getb1(Resultcallback resultcallback) {
//      resultcallback  new Retrofit.Builder()
//                .baseUrl(ApiService.url)
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .build()
//                .create(ApiService.class)
//                .getb1()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(new ResourceSubscriber<bang_1>() {
//                })
//    }
    }
}