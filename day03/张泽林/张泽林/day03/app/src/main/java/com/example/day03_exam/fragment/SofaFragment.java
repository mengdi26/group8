package com.example.day03_exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day03_exam.R;
import com.example.day03_exam.adpter.Vp1Adpter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SofaFragment extends Fragment {

    private TabLayout tab;
    private ViewPager vp;
    private Vp1Adpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sofa2, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tab=view.findViewById(R.id.tab);
        vp=view.findViewById(R.id.vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PageFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        adpter = new Vp1Adpter(getChildFragmentManager(), fragments);
        vp.setAdapter(adpter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("图片");
        tab.getTabAt(1).setText("视频");
        tab.getTabAt(2).setText("文本");
    }
}