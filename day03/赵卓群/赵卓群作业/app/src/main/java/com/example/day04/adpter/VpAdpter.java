package com.example.day04.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.day04.bean.FenleiBean;

import java.util.ArrayList;

public class VpAdpter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;
    private ArrayList<FenleiBean.DataBean> list;

    public VpAdpter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<FenleiBean.DataBean> list) {
        super(fm);
        this.fragments = fragments;
        this.list = list;
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
