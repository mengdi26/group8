package com.example.yuandan.mvp.presenter;

import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.model.MyModel;
import com.example.yuandan.mvp.model.bean.VwvBean;
import com.example.yuandan.mvp.ui.activity.VwvActivity;

public class VwvPresenter extends BasePresenter {
    private final VwvActivity vwvActivity;
    private final MyModel myModel;

    public VwvPresenter(VwvActivity vwvActivity) {

        this.vwvActivity = vwvActivity;
        myModel = new MyModel();
    }

    @Override
    public void start() {
        myModel.getData(new MyPresenter<VwvBean>() {
            @Override
            public void getData(VwvBean vwvBean) {
                vwvActivity.getData(vwvBean);
            }
        });
    }

    @Override
    public void start(Object[] t) {

    }
}
