package com.example.day03.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day03.bean.FragFxInfos;

import java.util.ArrayList;

public class FxFragAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<FragFxInfos.DataBean> list;

    public FxFragAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<FragFxInfos.DataBean> list) {
        super(fm);
        this.fragments = fragments;
        this.list = list;
    }

    public FxFragAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
