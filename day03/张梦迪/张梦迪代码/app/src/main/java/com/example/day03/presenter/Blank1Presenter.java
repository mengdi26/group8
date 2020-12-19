package com.example.day03.presenter;

import android.util.Log;

import com.example.day03.model.Blank1Model;
import com.example.day03.view.IView;

public class Blank1Presenter {
    private IView mView1;
    private final Blank1Model blank1Model;

    public Blank1Presenter(IView mView1) {
        this.mView1 = mView1;
        blank1Model = new Blank1Model();
    }

    public void startss(int page) {
        blank1Model.que(page, new JkCallBack() {
            @Override
            public void showTure(Object object) {
                mView1.showTure(object);
                Log.e("TAG", "showTure: P层成功");
            }

            @Override
            public void showNo(String msg) {
                mView1.showNo(msg);
                Log.e("TAG", "showNo: P层失败" + msg);
            }
        });
    }
}
