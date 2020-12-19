package com.example.day03.presenter;

import android.util.Log;

import com.example.day03.model.FxModel;
import com.example.day03.view.IView;

public class FxPresenter {
    private IView mViewFx;
    private final FxModel fxModel;

    public FxPresenter(IView mViewFx) {
        this.mViewFx = mViewFx;
        fxModel = new FxModel();
    }

    public void starts() {
        fxModel.quests(new JkCallBack() {
            @Override
            public void showTure(Object object) {
                mViewFx.showTure(object);
                Log.e("TAG", "showTure: P层请求成功");
            }

            @Override
            public void showNo(String msg) {
                mViewFx.showNo(msg);
                Log.e("TAG", "showNo: P曾失败");
            }
        });
    }
}
