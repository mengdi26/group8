package com.example.day04.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04.R;
import com.example.day04.bean.HotBean;

import java.util.ArrayList;

public class RvAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HotBean.DataBean> list;

    public RvAdpter(Context context, ArrayList<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_heng1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        HotBean.DataBean dataBean = list.get(position);
        viewHolder.tv_title.setText(dataBean.getTitle());
        viewHolder.tv_dizhi.setText(dataBean.getLocation());
        viewHolder.time.setText(dataBean.getStartTime());
        Glide.with(context).load(dataBean.getCover()).into(viewHolder.iv_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_image;
        public TextView tv_title;
        public TextView tv_dizhi;
        public TextView time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_image = (ImageView) rootView.findViewById(R.id.iv_image);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_dizhi = (TextView) rootView.findViewById(R.id.tv_dizhi);
            this.time = (TextView) rootView.findViewById(R.id.time);
        }

    }
}
