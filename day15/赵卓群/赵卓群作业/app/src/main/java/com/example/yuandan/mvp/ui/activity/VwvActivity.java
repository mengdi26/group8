package com.example.yuandan.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;

import com.example.yuandan.App;
import com.example.yuandan.R;
import com.example.yuandan.adapter.VwvAdapter;
import com.example.yuandan.base.BaseActivity;
import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.model.bean.VwvBean;
import com.example.yuandan.mvp.presenter.VwvPresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VwvActivity extends BaseActivity {


    @BindView(R.id.vwv_act)
    ViewPager vwvAct;
    @BindView(R.id.tv_go)
    TextView tvGo;

    @Override
    protected BasePresenter createPresenter() {
        return new VwvPresenter(this);
    }

    @Override
    protected void initData() {
        createPresenter().start();
    }

    @Override
    protected void init() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.guide_page_one);
        list.add(R.drawable.guide_page_two);
        list.add(R.drawable.guide_page_three);

        VwvAdapter adapter = new VwvAdapter(this, list);
        vwvAct.setAdapter(adapter);

        vwvAct.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==list.size()-1){
                    tvGo.setVisibility(View.VISIBLE);
                }else {
                    tvGo.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VwvActivity.this,SelectActivity.class));
                App.addSP("ok",true);
                finish();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vwv;
    }

    @Override
    public void getData(Object o) {
        VwvBean bean = (VwvBean) o;
        App.addString("data",bean.getData());
    }
}