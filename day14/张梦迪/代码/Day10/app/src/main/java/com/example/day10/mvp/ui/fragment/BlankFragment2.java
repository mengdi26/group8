package com.example.day10.mvp.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day10.R;
import com.example.day10.adpter.Frag2Adapter;
import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.bean.BannerBean;
import com.example.day10.mvp.model.bean.TitleBean;
import com.example.day10.mvp.presenter.Frag2Presenter;

import java.util.ArrayList;

import butterknife.BindView;


public class BlankFragment2 extends BaseFragment {


    @BindView(R.id.rec_frag2)
    RecyclerView recFrag2;
    private Frag2Adapter adapter;
    private ArrayList<TitleBean.DataBean> titleList;
    private ArrayList<BannerBean.DataBean> bannerList;

    @Override
    protected void init() {
        recFrag2.setLayoutManager(new LinearLayoutManager(getContext()));
        bannerList = new ArrayList<>();
        titleList = new ArrayList<>();
        adapter = new Frag2Adapter(getContext(), bannerList, titleList,getActivity().getSupportFragmentManager());
        recFrag2.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        createPresenter().start();
    }

    @Override
    protected BasePresenter createPresenter() {
        return new Frag2Presenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank2;
    }

    private int pos = 0;

    @Override
    public void getData(Object o) {
        if (pos == 0) {
            BannerBean bannerBean = (BannerBean) o;
            bannerList.addAll(bannerBean.getData());
            pos++;
        }else {
            TitleBean titleBean = (TitleBean) o;
            titleList.addAll(titleBean.getData());
        }
        adapter.notifyDataSetChanged();
    }
}