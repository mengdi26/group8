package com.example.myapplication.mvp.model;

import com.example.myapplication.R;
import com.example.myapplication.base.App;
import com.example.myapplication.callback.RxCallBack;

import org.json.JSONException;

import java.io.IOException;

import javax.net.ssl.SSLException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RxObservable<T> implements Observer {
    private RxCallBack<T> callBack;

    public RxObservable(RxCallBack<T> callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object value) {
        callBack.onSuccessData((T) value);
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof IOException){
            callBack.onError(App.context().getString(R.string.connec_exception));
        }else if(e instanceof JSONException){
            callBack.onError(App.context().getString(R.string.json_parse_exception));
        }else if(e instanceof SSLException){
            callBack.onError(App.context().getString(R.string.ssl_exception));
        }
    }

    @Override
    public void onComplete() {

    }
}
