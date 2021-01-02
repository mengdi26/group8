package com.example.day10.adpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.day10.R;
import com.example.day10.mvp.model.bean.BannerBean;
import com.example.day10.mvp.model.bean.TitleBean;
import com.example.day10.mvp.ui.fragment.HomeFragment;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Frag2Adapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<BannerBean.DataBean> bannerList;
    private ArrayList<TitleBean.DataBean> titleList;
    private final FragmentManager supportFragmentManager;
    private TitleAdapter adapter;

    public Frag2Adapter(Context context, ArrayList<BannerBean.DataBean> bannerList, ArrayList<TitleBean.DataBean> titleList, FragmentManager supportFragmentManager) {
        this.context = context;
        this.bannerList = bannerList;
        this.titleList = titleList;
        this.supportFragmentManager = supportFragmentManager;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view0 = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
            return new ViewHolder0(view0);
        } else {
            View view1 = LayoutInflater.from(context).inflate(R.layout.item_frag, parent, false);
            return new ViewHolder1(view1);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==0){
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            ArrayList<String> title = new ArrayList<>();

            for (BannerBean.DataBean dataBean : bannerList) {
                title.add(dataBean.getTitle());
            }

            viewHolder0.bannerItem
                    .setImages(bannerList)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            BannerBean.DataBean bannerBean = (BannerBean.DataBean) path;
                            Glide.with(context).load(bannerBean.getImagePath()).into(imageView);
                        }
                    })
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                    .setBannerTitles(title)
                    .start();
        }else {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;

            ArrayList<Fragment> list = new ArrayList<>();
            ArrayList<String> title = new ArrayList<>();

            TitleAdapter adapter = new TitleAdapter(supportFragmentManager, list, title);
            viewHolder1.vwvFrag2.setAdapter(adapter);
            viewHolder1.tabFrag2.setupWithViewPager(viewHolder1.vwvFrag2);

            for (int i = 0; i < titleList.size(); i++) {
                HomeFragment homeFragment = new HomeFragment();
                list.add(homeFragment);
                title.add(titleList.get(i).getName());

                Bundle bundle = new Bundle();
                bundle.putInt("id",titleList.get(i).getId());
                homeFragment.setArguments(bundle);
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    static
    class ViewHolder0 extends RecyclerView.ViewHolder {
        @BindView(R.id.banner_item)
        Banner bannerItem;

        ViewHolder0(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.tab_frag2)
        TabLayout tabFrag2;
        @BindView(R.id.vwv_frag2)
        ViewPager vwvFrag2;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
