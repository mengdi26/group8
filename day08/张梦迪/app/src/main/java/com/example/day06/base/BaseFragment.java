package com.example.day06.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<T> extends Fragment implements IBaseView<T> {


    private Unbinder mBind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        View view = null;
        if (layoutId !=0){
            view = inflater.inflate(layoutId, null);
            mBind = ButterKnife.bind(this, view);
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //找控件
        init();
        //加载数据
        initData();
    }

    protected  void initData(){

    }

    protected abstract void init();

    protected abstract int getLayoutId() ;

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(String msg) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mBind!=null){
            mBind.unbind();
        }
    }
}
