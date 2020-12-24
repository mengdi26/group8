package com.example.sx_day05.mvp.model;


import com.example.sx_day05.mvp.model.api.ApiService;

import java.util.Map;

import javax.inject.Inject;


public class RxOpretorImpl {
    @Inject
    ApiService mApiService;

    public RxOpretorImpl() {

    }

    //封装一个get请求的方法
    public void requestData(String url) {
        RxOperator.threadtransformer(mApiService.requestGetData(url)).
                subscribe(null);

    }


    //封装一个get请求的方法
    public <T> void requestData(String url, Map<String,T> params) {
         RxOperator.threadtransformer(mApiService.requestGetData(url,params)).
                 subscribe(null);


    }



}