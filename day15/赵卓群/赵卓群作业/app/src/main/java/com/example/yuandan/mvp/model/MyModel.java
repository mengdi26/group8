package com.example.yuandan.mvp.model;

import android.util.Log;

import com.example.yuandan.mvp.model.bean.HomeBannerBean;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;
import com.example.yuandan.mvp.model.bean.VwvBean;
import com.example.yuandan.mvp.model.net.ApiService;
import com.example.yuandan.mvp.presenter.MyPresenter;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {

    public void getData(MyPresenter<VwvBean> vwvBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getData("ios")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<VwvBean>() {
                    @Override
                    public void onNext(VwvBean vwvBean) {
                        vwvBeanMyPresenter.getData(vwvBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getHome(MyPresenter myPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Home)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHomeBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<HomeBannerBean>() {
                    @Override
                    public void onNext(HomeBannerBean homeBannerBean) {
                        myPresenter.getData(homeBannerBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        initTop(myPresenter);
                    }
                });
    }

    private void initTop(MyPresenter myPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Home)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHomeTop()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<HomeTopIcBean>() {
                    @Override
                    public void onNext(HomeTopIcBean homeTopIcBean) {
                        myPresenter.getData(homeTopIcBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
