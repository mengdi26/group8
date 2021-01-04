package com.example.yuandan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yuandan.R;
import com.example.yuandan.mvp.model.bean.HomeBannerBean;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HomeBannerBean.DataBean.ListBean> bannerList;
    private ArrayList<HomeTopIcBean.DataBean> list;

    public HomeAdapter(Context context, ArrayList<HomeBannerBean.DataBean.ListBean> bannerList, ArrayList<HomeTopIcBean.DataBean> list) {
        this.context = context;
        this.bannerList = bannerList;
        this.list = list;
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
            View view1 = LayoutInflater.from(context).inflate(R.layout.rec_home, parent, false);
            return new ViewHolder1(view1);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type==0){
            ViewHolder0 viewHolder0 = (ViewHolder0) holder;
            viewHolder0.bannerItem
                    .setImages(bannerList)
                    .setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            HomeBannerBean.DataBean.ListBean bean = (HomeBannerBean.DataBean.ListBean) path;
                            Glide.with(context).load(bean.getBanner()).into(imageView);
                        }
                    })
                    .start();
        }else {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.recHome.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

            HomeRecAdapter adapter = new HomeRecAdapter(context, list);
            viewHolder1.recHome.setAdapter(adapter);
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
        @BindView(R.id.rec_home)
        RecyclerView recHome;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
