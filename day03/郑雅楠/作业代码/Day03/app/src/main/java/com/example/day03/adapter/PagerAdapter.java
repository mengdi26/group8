package com.example.day03.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.day03.bean.Info_Navgation;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment>mFragments;
    private ArrayList<Info_Navgation.DataBean>list;
    private Context mContext;

    public PagerAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<Info_Navgation.DataBean> list, Context context) {
        super(fm);
        mFragments = fragments;
        this.list = list;
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getName();
    }
}
