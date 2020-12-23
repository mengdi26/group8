package com.example.day06.mvp.model;

import com.example.day06.di.component.DaggerOkComponent;
import com.example.day06.mvp.model.api.ApiService;

import java.lang.reflect.AnnotatedElement;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class RxOpretorImpl {
    @Inject
    ApiService mApiService;
    public RxOpretorImpl(){
        DaggerOkComponent.create().getSingleApiService(this);
    }

//    //封装get请求发方法
//    public <T> void rxGetRequest(String url, Map<String,T> params){
//        mApiService.requestGetData(url,params).
//    }
}
