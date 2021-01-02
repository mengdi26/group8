package com.example.day10.mvp.presenter;

import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.MyModel;
import com.example.day10.mvp.ui.fragment.BlankFragment2;

public class Frag2Presenter extends BasePresenter {

    private final MyModel myModel;
    private final BlankFragment2 blankFragment2;

    public Frag2Presenter(BlankFragment2 blankFragment2) {
        super();
        this.blankFragment2 = blankFragment2;
        myModel = new MyModel();
    }

    @Override
    public void start() {
        myModel.getData(new MyPresenter() {
            @Override
            public void getData(Object o) {
                blankFragment2.getData(o);
            }
        });
    }

    @Override
    public void start(Object[] t) {

    }
}
