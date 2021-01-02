package com.example.day10.mvp.model;

import com.example.day10.mvp.model.bean.BannerBean;
import com.example.day10.mvp.model.bean.FuLiBean;
import com.example.day10.mvp.model.bean.ItemBean;
import com.example.day10.mvp.model.bean.TitleBean;
import com.example.day10.mvp.model.net.ApiService;
import com.example.day10.mvp.presenter.MyPresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyModel {
    public void getFuLi(int pos, MyPresenter<FuLiBean> fuLiBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getFuLi(pos)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<FuLiBean>() {
                    @Override
                    public void onNext(FuLiBean fuLiBean) {
                        fuLiBeanMyPresenter.getData(fuLiBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getData(MyPresenter myPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Wan)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<BannerBean>() {
                    @Override
                    public void onNext(BannerBean bannerBean) {
                        myPresenter.getData(bannerBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                        initTitle(myPresenter);
                    }
                });
    }

    private void initTitle(MyPresenter myPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Wan)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getTitle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<TitleBean>() {
                    @Override
                    public void onNext(TitleBean titleBean) {
                        myPresenter.getData(titleBean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getItem(int id, MyPresenter<ItemBean> itemBeanMyPresenter) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Wan)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class)
                .getItem(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<ItemBean>() {
                    @Override
                    public void onNext(ItemBean itemBean) {
                        itemBeanMyPresenter.getData(itemBean);
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
