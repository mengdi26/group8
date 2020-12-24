package com.example.myapplication.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.manage.ContiainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter,T> extends AppCompatActivity implements iBaseView<T> {
    private Unbinder bind;
    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = getLayoutId();
        if(layout!=0){
            setContentView(layout);
        }
        bind = ButterKnife.bind(this);
        ContiainManager.getManager().addActivity(this);
        presenter=createPresenter();
        if(presenter!=null){
            presenter.attachView(this);
        }
        //初始化View
        init();
        initData();
    }
    //获取p层对象
    protected P getPresenter(){
        if(presenter!=null){
            return presenter;
        }
        return null;
    }

    protected  void initData(){

    };

    protected abstract void init();

    protected abstract P createPresenter();

    protected abstract int getLayoutId();


    @Override
    public void onScuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }
}
