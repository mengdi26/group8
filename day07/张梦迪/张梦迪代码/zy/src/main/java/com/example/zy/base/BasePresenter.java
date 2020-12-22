package com.example.zy.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter<V extends IBaseView<T>,T> implements IPresenter<T> {
    protected WeakReference<V> mView;
    private CompositeDisposable mComposite = new CompositeDisposable();

    protected void addDisposable(Disposable disposable){
        if (mComposite !=null){
            mComposite.add(disposable);
        }
    }

    protected void attachView(V view){
         mView = new WeakReference<>(view);
    }

    protected void detachView(){
        if (mView !=null){
            mView.clear();
            mView = null;
        }
        deleteDisposable();
    }

    private void deleteDisposable() {
        if (mComposite !=null && !mComposite.isDisposed()){
            mComposite.dispose();
            mComposite.clear();
            mComposite = null;
        }
    }


    @Override
    public void start() {

    }

    @Override
    public void start(Object[] t) {

    }
}
