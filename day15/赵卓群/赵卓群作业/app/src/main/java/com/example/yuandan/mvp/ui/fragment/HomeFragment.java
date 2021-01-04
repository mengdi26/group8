package com.example.yuandan.mvp.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yuandan.R;
import com.example.yuandan.adapter.HomeAdapter;
import com.example.yuandan.base.BaseFragment;
import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.model.bean.HomeBannerBean;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;
import com.example.yuandan.mvp.presenter.HomePresenter;

import java.util.ArrayList;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.home_rec)
    RecyclerView homeRec;
    private ArrayList<HomeTopIcBean.DataBean> list;
    private ArrayList<HomeBannerBean.DataBean.ListBean> homeBanner;
    private HomeAdapter adapter;

    @Override
    protected void init() {
        createPresenter().start();
    }

    @Override
    protected void initData() {

        homeRec.setLayoutManager(new LinearLayoutManager(getContext()));

        homeBanner = new ArrayList<>();
        list = new ArrayList<>();

        adapter = new HomeAdapter(getContext(), homeBanner, list);
        homeRec.setAdapter(adapter);

    }

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    private int pos = 0;
    @Override
    public void getData(Object o) {
        if (pos==0){
            HomeBannerBean bannerBean = (HomeBannerBean) o;
            homeBanner.addAll(bannerBean.getData().getList());
            pos++;
        }else {
            HomeTopIcBean topIcBean = (HomeTopIcBean) o;
            list.addAll(topIcBean.getData());
            pos--;
        }
        adapter.notifyDataSetChanged();
    }
}