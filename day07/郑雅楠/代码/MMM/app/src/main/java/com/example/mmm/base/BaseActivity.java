package com.example.mmm.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter,T>extends AppCompatActivity implements IBaseView<T>{

    private P mMpresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        int id=getLayoutId();
        if(id!=0)
            setContentView(id);
        ButterKnife.bind(this);
        //创建p层对象
        mMpresenter = creataPresenter();
        if(mMpresenter!=null){
            mMpresenter.attachView(this);
        }
        //初始胡
        initView();
        initData();
    }
    //获取P陈对象
protected  P getPresenter(){
        if(mMpresenter!=null){
            return  mMpresenter;
        }
        return null;
}
    protected abstract void initData();

    protected abstract void initView();

    protected abstract P creataPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onSuccecc(Object object) {

    }

    @Override
    public void oneFial(String msg) {

    }
}
