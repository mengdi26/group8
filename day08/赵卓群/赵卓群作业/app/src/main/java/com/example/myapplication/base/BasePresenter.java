package com.example.myapplication.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends iBaseView,T> implements iBasePresenter<T> {

    private CompositeDisposable mComposite = new CompositeDisposable();
    private WeakReference<V> mView;
    //添加网络开关
    protected void addDisposable(Disposable disposable){
        if(mComposite!=null){
            mComposite.add(disposable);
        }
    }
    //使用弱引用
    protected void attachView(V view){
        mView= new WeakReference<V>(view);
    }
    //2.释放V层资源的同时断开网络开关
    protected void detachView(){
        if(mView!=null){
            mView.clear();
            mView=null;
        }
        //断开网络链接
        if(mComposite!=null){
            mComposite.dispose();
            mComposite.clear();
            mComposite=null;
        }
    }


    @Override
    public void onStart(T t) {

    }

    @Override
    public void onStart(T... t) {

    }
}
