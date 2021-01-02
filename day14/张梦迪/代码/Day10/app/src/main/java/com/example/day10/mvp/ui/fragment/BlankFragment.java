package com.example.day10.mvp.ui.fragment;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day10.R;
import com.example.day10.adpter.FuLiAdapter;
import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.bean.FuLiBean;
import com.example.day10.mvp.presenter.Frag1Presenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;

import butterknife.BindView;


public class BlankFragment extends BaseFragment {


    @BindView(R.id.rec_frag1)
    RecyclerView recFrag1;
    @BindView(R.id.ls_frag1)
    SmartRefreshLayout lsFrag1;
    private ArrayList<FuLiBean.ResultsBean> list;
    private FuLiAdapter adapter;
    private int pos = 3;

    @Override
    protected void init() {
        recFrag1.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new FuLiAdapter(getContext(), list);
        recFrag1.setAdapter(adapter);
    }

    @Override
    protected void initData() {

        createPresenter().start(pos);

        lsFrag1.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pos++;
                createPresenter().start(pos);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                list.clear();
                pos=0;
                createPresenter().start(pos);
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return new Frag1Presenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void getData(Object o) {
        FuLiBean bean = (FuLiBean) o;
        list.addAll(bean.getResults());
        adapter.notifyDataSetChanged();

        lsFrag1.finishLoadMore();
        lsFrag1.finishRefresh();

    }
}