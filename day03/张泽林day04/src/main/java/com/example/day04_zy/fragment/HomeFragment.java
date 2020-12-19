package com.example.day04_zy.fragment;


import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.day04_zy.R;
import com.example.day04_zy.adapter.RlvAdapter;
import com.example.day04_zy.bean.Bean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private RecyclerView rv;
    private ViewPager vp;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ArrayList<Bean.DataBean> list;
    private RlvAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
        vp = view.findViewById(R.id.vp);
        tab = view.findViewById(R.id.tab);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv3 = view.findViewById(R.id.tv3);
        iv1 = view.findViewById(R.id.iv1);
        iv2 = view.findViewById(R.id.iv2);
        iv3 = view.findViewById(R.id.iv3);

        tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        tv3.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线

        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        adapter = new RlvAdapter(list, getContext());
        rv.setAdapter(adapter);

        fragments = new ArrayList<>();
        fragments.add(new HomeSonFragment());

    }

}
