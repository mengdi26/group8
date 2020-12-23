package com.example.day06.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day06.manager.ContainManager;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public abstract class BaseActivity<T> extends AppCompatActivity implements IBaseView<T> {

    private Unbinder mBind;
    //  private P mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Activity加载布局
        int layoutId = getLayoutId();

        if (layoutId != 0) {
            //加载布局
            setContentView(layoutId);
            //绑定butterKnife
            mBind = ButterKnife.bind(this);
            //将所有的Activity添加到集合里
            ContainManager.getmManager().addActivity(this);
            //加载布局
            init();
            //加载数据
            initData();

        }


    }

    protected  void initData(){

    }

    protected abstract void init();


    protected abstract void click(View view);

    protected abstract void createPresenter();

    protected abstract int getLayoutId();


    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }
//取消邦定
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }

    }
}
