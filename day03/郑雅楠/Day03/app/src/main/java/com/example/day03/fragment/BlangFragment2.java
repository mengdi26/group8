package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03.R;
import com.example.day03.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class BlangFragment2 extends Fragment {


    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<String> mTitles;

    public BlangFragment2() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blang2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(getView());
    }

    private void initView(View view) {
        mTab = view.findViewById(R.id.tab);
        mVp = view.findViewById(R.id.vp);
        mTitles = new ArrayList<>();
        mTitles.add("经验榜");
        mTitles.add("土豪榜");
        mTitles.add("签到榜");
        //
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new SecondFragment2());
        fragments.add(new ThreeFragment2());

        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fragments, mTitles);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

    }
}