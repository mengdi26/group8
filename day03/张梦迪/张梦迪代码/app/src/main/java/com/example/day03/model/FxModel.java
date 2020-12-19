package com.example.day03.model;

import android.util.Log;

import com.example.day03.ApiService;
import com.example.day03.bean.FragFxInfos;
import com.example.day03.presenter.JkCallBack;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FxModel {
    public void quests(final JkCallBack jkCallBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getFxFrag()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FragFxInfos>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FragFxInfos value) {
                        jkCallBack.showTure(value);
                        Log.e("TAG", "onNext: M层请求成功");
                    }

                    @Override
                    public void onError(Throwable e) {
                        jkCallBack.showNo(e.getMessage());
                        Log.e("TAG", "onError: M层请求失败"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
