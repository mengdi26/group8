package com.example.day03.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.adapter.FxFraBlank1Adapter;
import com.example.day03.bean.FxFragRelInfos;
import com.example.day03.presenter.Blank1Presenter;
import com.example.day03.view.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment1 extends Fragment implements IView {


    private Blank1Presenter blank1Presenter;
    private ArrayList<FxFragRelInfos.DataBean.ListBean> listBeans;
    private FxFraBlank1Adapter fxFraBlank1Adapter;


    public BlankFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        blank1Presenter = new Blank1Presenter(this);
        initView(getView());
    }

    private void initView(View view) {
        final RecyclerView mRelBlank1 = view.findViewById(R.id.rel_blank1);
        mRelBlank1.setLayoutManager(new LinearLayoutManager(getContext()));
        listBeans = new ArrayList<>();
        final Bundle arguments = getArguments();
        final int page = arguments.getInt("page");
        fxFraBlank1Adapter = new FxFraBlank1Adapter(listBeans, getContext());
        mRelBlank1.setAdapter(fxFraBlank1Adapter);
        blank1Presenter.startss(page);

    }

    @Override
    public void showTure(Object object) {
        if (object instanceof FxFragRelInfos){
            final FxFragRelInfos fxFragRelInfos = (FxFragRelInfos) object;
            final List<FxFragRelInfos.DataBean.ListBean> list = fxFragRelInfos.getData().getList();
            listBeans.addAll(list);
            fxFraBlank1Adapter.notifyDataSetChanged();
        }
        Log.e("TAG", "showTure: 网络成功");
    }

    @Override
    public void showNo(String msg) {
        Log.e("TAG", "showNo: 网络失败"+msg);
    }
}
