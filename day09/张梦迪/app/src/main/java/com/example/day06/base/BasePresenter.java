package com.example.day06.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;

//在泛型T里定义V继承IVaseView实线V层
//1、java里面四种引用  强引用    弱引用   软引用    虚引用
//连接M 层和V层  2、处理业务逻辑   3、断开网络请求
public class BasePresenter<V extends IBaseView<T>, T> implements IPresenter<T> {
    private WeakReference<V> mView;
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();


    //1、用弱引用修饰V层  方便GC回收，2、P层关联V层
    protected void attachView(V view) {
        mView = new WeakReference<>(view);

    }

    //释放资源 让P层断开网络请求
    protected void dettachView() {
        //释放资源
        if (mView != null) {
            mView.clear();
            mView = null;
        }
        //断开网络请求
        disPosable();
    }

    private void disPosable() {
        //如果网络请求不为空并且非网络请求是否断开
        if (mCompositeDisposable != null && !mCompositeDisposable.isDisposed()) {
            //断开网络请求
            mCompositeDisposable.dispose();
            //清空
            mCompositeDisposable.clear();
            //赋值为空
            mCompositeDisposable = null;
        }
    }


    @Override
    public void start() {
        //处理业务逻辑
    }

    @Override
    public void start(Object[] t) {
//处理业务逻辑
    }


}
