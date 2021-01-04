package com.example.yuandan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.yuandan.R;
import com.example.yuandan.mvp.model.bean.HomeTopIcBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeRecAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HomeTopIcBean.DataBean> list;

    public HomeRecAdapter(Context context, ArrayList<HomeTopIcBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_rec, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HomeTopIcBean.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getImageUrl()).into(viewHolder.ivImg);
        viewHolder.tvName.setText(dataBean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_a)
        TextView tvA;
        @BindView(R.id.iv_img)
        ImageView ivImg;
        @BindView(R.id.tv_name)
        TextView tvName;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
