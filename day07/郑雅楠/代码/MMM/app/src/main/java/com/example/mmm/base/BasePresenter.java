package com.example.mmm.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>,T> implements IBasePresenter<T> {
   //链接m层和v层
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<V> mVWeakReference;

    //todo 添加网络开关
    protected  void addDisposables(Disposable disposable){
        mCompositeDisposable = new CompositeDisposable();
        if(mCompositeDisposable!=null){
            mCompositeDisposable.add(disposable);
        }
    }
    //弱引用修饰v层 方便gs 回收 p层关联v
    protected  void attachView(V view){
        mVWeakReference = new WeakReference<V>(view);
    }
    //释放v层资源断开网络开关
    protected  void detachView(){
        if(mVWeakReference!=null){
            mVWeakReference.clear();
            mVWeakReference=null;
        }
        deleteDisposable();
    }

    private void deleteDisposable() {
        if(mCompositeDisposable!=null&&!mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
            mCompositeDisposable.clear();

            mCompositeDisposable=null;
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void start(T... t) {

    }
}
