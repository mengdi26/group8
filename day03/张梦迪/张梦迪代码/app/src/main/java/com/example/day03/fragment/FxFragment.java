package com.example.day03.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.day03.R;
import com.example.day03.adapter.FxFragAdapter;
import com.example.day03.bean.FragFxInfos;
import com.example.day03.presenter.FxPresenter;
import com.example.day03.view.IView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FxFragment extends Fragment implements IView {


    private FxPresenter fxPresenter;
    private ViewPager mVpFx;
    private TabLayout mTabFx;

    public FxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fx, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fxPresenter = new FxPresenter(this);
        initView(getView());
    }

    private void initView(View view) {
        mVpFx = view.findViewById(R.id.vp_fx);
        mTabFx = view.findViewById(R.id.tab_fx);
        fxPresenter.starts();


    }

    @Override
    public void showTure(Object object) {
        if (object instanceof FragFxInfos) {
            final FragFxInfos fragFxInfos = (FragFxInfos) object;
            final ArrayList<FragFxInfos.DataBean> data = (ArrayList<FragFxInfos.DataBean>) fragFxInfos.getData();
            final ArrayList<Fragment> fragments = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                final BlankFragment1 blankFragment1 = new BlankFragment1();
                final int type = data.get(i).getType();
                final Bundle bundle = new Bundle();
                bundle.putInt("type", type);
                blankFragment1.setArguments(bundle);
                fragments.add(blankFragment1);
                final FxFragAdapter fxFragAdapter = new FxFragAdapter(getChildFragmentManager(), fragments, data);
                mVpFx.setAdapter(fxFragAdapter);
                mTabFx.setupWithViewPager(mVpFx);
            }

            Log.e("TAG", "showTure: 网络成功");
        }
    }

    @Override
    public void showNo(String msg) {
        Log.e("TAG", "showNo: 网络失败" + msg);
    }
}
