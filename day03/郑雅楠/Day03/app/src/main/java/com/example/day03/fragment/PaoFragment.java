package com.example.day03.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.day03.R;
import com.example.day03.adapter.PagerAdapter;
import com.example.day03.adapter.RvAdapter;
import com.example.day03.bean.Info_Activity;
import com.example.day03.bean.Info_Navgation;
import com.example.day03.bean.Info_Type;
import com.example.day03.presenter.MainPrsenter;
import com.example.day03.view.MainView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PaoFragment extends Fragment implements MainView {


    private RecyclerView mRel;
    private TabLayout mTab;
    private ViewPager mVp;
    private MainPrsenter mMainPrsenter;
    private ArrayList<Info_Activity.DataBean> mHotlist;
    private ArrayList<Info_Navgation.DataBean> mNav;
    private ArrayList<Info_Type.DataBean.ListBean> mType;
    private RvAdapter mRvAdapter;

    public PaoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pao, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建p层对象
        mMainPrsenter = new MainPrsenter(this);
        initView(getView());
        initData();
    }

    private void initData() {
      mMainPrsenter.getActivity();
      mMainPrsenter.getTab();


    }

    private void initView(View view) {
        mRel = view.findViewById(R.id.rel);
        mTab = view.findViewById(R.id.tab);
        mVp = view.findViewById(R.id.vp);
        //初始化数据源
        mHotlist = new ArrayList<>();
        mNav = new ArrayList<>();
        mType = new ArrayList<>();
        //布局管理器
        mRel.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));
        //适配器
        mRvAdapter = new RvAdapter(mHotlist, getActivity());
        mRel.setAdapter(mRvAdapter);


    }

    @Override
    public void onSuccess(Object object) {
        if(object instanceof Info_Activity){
            Info_Activity info_activity= (Info_Activity) object;
            List<Info_Activity.DataBean> data = info_activity.getData();
            mHotlist.addAll(data);
            mRvAdapter.notifyDataSetChanged();
        }
        if(object instanceof Info_Navgation){
            Info_Navgation info_navgation= (Info_Navgation) object;
            List<Info_Navgation.DataBean> data = info_navgation.getData();
            mNav.addAll(data);
            //创建fragment集合
            ArrayList<Fragment> fragments = new ArrayList<>();
            for (int i = 0; i < mNav.size(); i++) {
                B1Fragment b1Fragment = new B1Fragment();
                int type = mNav.get(i).getType();
                Bundle bundle = new Bundle();
                bundle.putInt("type",type);
                b1Fragment.setArguments(bundle);
                fragments.add(b1Fragment);
            }
            //适配器
            PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager(), fragments, mNav, getActivity());
            mVp.setAdapter(pagerAdapter);
            mTab.setupWithViewPager(mVp);

        }
    }
}