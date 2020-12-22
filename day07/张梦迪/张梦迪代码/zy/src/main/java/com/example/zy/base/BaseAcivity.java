package com.example.zy.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.zy.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseAcivity<P extends BasePresenter , T> extends AppCompatActivity implements IBaseView<T>{


    private Unbinder mBind;
    private P mPresetner;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       int layoutId =  getLayoutId();
       if (layoutId != 0 )
           setContentView(layoutId);
            mBind = ButterKnife.bind(this);

            ContainManager.getmManager().addActivity(this);
          mPresetner =   createPresenter();
          if (mPresetner !=null)
              mPresetner.attachView(this);

          init();
          initData();


    }

    protected abstract void initData();

    protected abstract void init();

    protected abstract P createPresenter();

    protected abstract int getLayoutId() ;

    @Override
    public void onSuccess(Object o) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind !=null){
            mBind.unbind();
        }
        if (mPresetner !=null){
            mPresetner.detachView();
            mPresetner = null;
        }
    }
}
