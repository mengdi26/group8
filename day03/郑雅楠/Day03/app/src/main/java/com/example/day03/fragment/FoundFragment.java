package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class FoundFragment extends Fragment {


    private RecyclerView mRel;
    private TabLayout mTab;
    private ViewPager mVp;

    public FoundFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_found, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        mTab = view.findViewById(R.id.tab);
        mVp = view.findViewById(R.id.vp);
        //初始化标题集合
        ArrayList<String> titles = new ArrayList<>();
        titles.add("袍子");
        titles.add("社团");
        titles.add("排行榜");
        //初始化fragment集合
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PaoFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlangFragment2());
        //设置适配器
        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fragments, titles);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setIcon(R.drawable.selector);
        mTab.getTabAt(1).setIcon(R.drawable.selector);
        mTab.getTabAt(2).setIcon(R.drawable.selector);

    }
}