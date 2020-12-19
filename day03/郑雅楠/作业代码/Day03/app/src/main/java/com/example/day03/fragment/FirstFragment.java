package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.bean.bang_1;
import com.example.day03.presenter.MainPrsenter;
import com.example.day03.view.MainView;

import java.util.ArrayList;


public class FirstFragment extends Fragment implements MainView {


    private RecyclerView mRel;
    private ArrayList<bang_1.DataBean.ExpTopBean.ListBean> mList;
    private MainPrsenter mMainPrsenter;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mMainPrsenter = new MainPrsenter(this);
        initView(getView());
        initData();
    }

    private void initData() {
        mMainPrsenter.getb1();
    }

    private void initView(View view) {
        mRel = view.findViewById(R.id.rel);
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        //初始化数据源
        mList = new ArrayList<>();


    }

    @Override
    public void onSuccess(Object object) {

    }
}