package com.example.day10.mvp.presenter;

import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.MyModel;
import com.example.day10.mvp.model.bean.FuLiBean;
import com.example.day10.mvp.ui.fragment.BlankFragment;

public class Frag1Presenter extends BasePresenter {
    private final BlankFragment blankFragment;
    private final MyModel myModel;

    public Frag1Presenter(BlankFragment blankFragment) {
        super();
        this.blankFragment = blankFragment;
        myModel = new MyModel();
    }

    @Override
    public void start() {

    }

    @Override
    public void start(Object[] t) {
        int pos = (int) t[0];

        myModel.getFuLi(pos, new MyPresenter<FuLiBean>() {
            @Override
            public void getData(FuLiBean fuLiBean) {
                blankFragment.getData(fuLiBean);
            }
        });

    }
}
