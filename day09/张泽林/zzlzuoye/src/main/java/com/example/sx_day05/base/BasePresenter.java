package com.example.sx_day05.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>,T>implements IPresenter<T> {

    private WeakReference<V> mView;
    private CompositeDisposable mComposite = new CompositeDisposable();
    //添加网络开关
    protected void addDisposable(Disposable disposable){
        if (mComposite != null){
            mComposite.add(disposable);
        }
    }
    //1.用弱引用修饰v层 方便GC回收 2.P层关联v层
    public void attachView(V view) {
        mView = new WeakReference<V>(view);
    }

    //释放v层资源的同时断开网络开关
    public void detachView() {
        if (mView != null){
            mView.clear();
            mView =null;
        }
        deleteDisposable();
    }
    //添加网络开关
    private void deleteDisposable() {
        if (mComposite != null && !mComposite.isDisposed()){
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }


    @Override
    public void start(T t) {
        //处理业务逻辑
    }

    @Override
    public void start(T... t) {
        //处理业务逻辑
    }
}
