package com.example.newyear.mvp.ui.fragment;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newyear.Base.BaseFragment;
import com.example.newyear.Base.BasePresenter;
import com.example.newyear.R;
import com.example.newyear.mvp.adapter.RelAdapter;
import com.example.newyear.mvp.model.bean.Data;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;


public class FirstPageFragment extends BaseFragment {


    @BindView(R.id.ban)
    Banner ban;
    @BindView(R.id.ll)
    LinearLayout ll;
    @BindView(R.id.rel)
    RecyclerView rel;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {
        //初始化banner集合
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(R.drawable.b1);
        integers.add(R.drawable.b2);
        integers.add(R.drawable.b3);
        integers.add(R.drawable.b4);
        ban.setImages(integers);
        ban.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
        rel.setLayoutManager(new LinearLayoutManager(getContext()));
        //初始化数据源
        ArrayList<Data> data = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            data.add(new Data(R.drawable.b1,"股权投资资金基础知识"));
        }
        //适配器
        RelAdapter relAdapter = new RelAdapter(data, getContext());
        rel.setAdapter(relAdapter);


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_first_page;
    }
}