package com.example.mmm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<P extends BasePresenter,T> extends Fragment implements IBaseView<T> {

    private Unbinder mBind;
    private P mMp;
    private View mInflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int id=getLayoutId();
        if(id!=0){
            mInflate = inflater.inflate(id, null);
            mBind = ButterKnife.bind(mInflate);
        }
        mMp = createPresenter();
        if(mMp!=null){
            mMp.attachView(this);
        }
        return mInflate;
    }
    protected P getPresenter(){
        if(mMp!=null){
            return mMp;
        }
        return null;
    }

    protected abstract P createPresenter();

    protected abstract int getLayoutId();


    @Override
    public void onSuccecc(T object) {

    }

    @Override
    public void oneFial(String msg) {

    }
}
