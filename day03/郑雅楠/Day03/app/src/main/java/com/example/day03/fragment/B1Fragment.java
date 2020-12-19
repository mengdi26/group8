package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.adapter.ThreeAdapter;
import com.example.day03.bean.Info_Type;
import com.example.day03.presenter.MainPrsenter;
import com.example.day03.view.MainView;

import java.util.ArrayList;
import java.util.List;


public class B1Fragment extends Fragment implements MainView {


    private RecyclerView mRel;
    private MainPrsenter mMainPrsenter;
    private ArrayList<Info_Type.DataBean.ListBean> mList;
    private ThreeAdapter mThreeAdapter;
    private ArrayList<Info_Type.DataBean.ListBean.FilePathListBean> mFile;

    public B1Fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //p
        mMainPrsenter = new MainPrsenter(this);
        initView(getView());
        initDATA();
    }

    private void initDATA() {
        Bundle arguments = getArguments();
        int type = arguments.getInt("type");
        mMainPrsenter.getData(type);
    }

    private void initView(View view) {
        mRel = view.findViewById(R.id.rel);
        //初始化数据集合
        mList = new ArrayList<>();
        mFile = new ArrayList<>();
        mRel.setLayoutManager(new LinearLayoutManager(getContext()));
        //适配
        mThreeAdapter = new ThreeAdapter(mList, getContext());
        mRel.setAdapter(mThreeAdapter);

    }

    @Override
    public void onSuccess(Object object) {
        if(object instanceof  Info_Type){
            Info_Type info_type= (Info_Type) object;
            List<Info_Type.DataBean.ListBean> list = info_type.getData().getList();

            mList.addAll(list);
            //刷新适配器
            mThreeAdapter.notifyDataSetChanged();//刷新

        }

    }
}