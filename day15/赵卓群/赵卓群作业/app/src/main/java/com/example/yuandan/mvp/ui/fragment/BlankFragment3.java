package com.example.yuandan.mvp.ui.fragment;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.yuandan.R;
import com.example.yuandan.adapter.BlankAdapter;
import com.example.yuandan.base.BaseFragment;
import com.example.yuandan.base.BasePresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class BlankFragment3 extends BaseFragment {


    @BindView(R.id.tab_blank3)
    TabLayout tabBlank3;
    @BindView(R.id.vwv_blank3)
    ViewPager vwvBlank3;


    @Override
    protected void init() {

    }

    @Override
    protected void initData() {
        ArrayList<String> title = new ArrayList<>();
        title.add("关注");
        title.add("推荐");
        title.add("广场");
        title.add("视频");
        title.add("摄影");
        title.add("知识文章");
        title.add("悬赏");

        ArrayList<Fragment> list = new ArrayList<>();


        for (int i = 0; i < title.size(); i++) {
            HomeFragment homeFragment = new HomeFragment();
            list.add(homeFragment);
        }

        BlankAdapter adapter = new BlankAdapter(getChildFragmentManager(), list, title);

        vwvBlank3.setAdapter(adapter);
        tabBlank3.setupWithViewPager(vwvBlank3);

        tabBlank3.getTabAt(1).select();

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank3;
    }

    @Override
    public void getData(Object o) {

    }
}