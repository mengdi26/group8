package com.example.myapplication.mvp.model;

import com.example.myapplication.callback.RxCallBack;
import com.example.myapplication.mvp.api.ApiService;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;


public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {

    }

    //封装一个get请求的方法
    //没数据，没请求头
    public <T> void requestData(String url, RxCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(new RxObservable(callBack));
    }

    //有数据，没请求头
    public <T> void requestData(String url, Map<String, T> params, RxCallBack<T> callBack) {
        RxOperator.threadtransformer(mApiService.requestGetData(url, params))
                .subscribe(new RxObservable(callBack));
    }

    //有数据，有请求头
    public <T> void requestData(String url, Map<String, T> param, HashMap<String, T> header, RxCallBack<T> callBack) {
        if (param != null && header != null) {
            RxOperator.threadtransformer(mApiService.requestGetData(url, param, header))
                    .subscribe(new RxObservable(callBack));
        } else {
            requestData(url, callBack);
        }

    }


}
