package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.R;
import com.example.day03.bean.FxFragRelInfos;

import java.util.ArrayList;

public class FxFraBlank1Adapter extends RecyclerView.Adapter {
private ArrayList<FxFragRelInfos.DataBean.ListBean>list;
private Context context;

    public FxFraBlank1Adapter(ArrayList<FxFragRelInfos.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            final View left = LayoutInflater.from(context).inflate(R.layout.layout_leftitem1, parent, false);
            return new LeftHolder(left);
        }else if (viewType == 2){
            final View center = LayoutInflater.from(context).inflate(R.layout.layout_centeritem2, parent, false);
            return new CenterHolder(center);
        }
        final View right = LayoutInflater.from(context).inflate(R.layout.layout_rightitem3, parent, false);
        return new RightHolder(right);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int itemViewType = getItemViewType(position);
        if (itemViewType == 1){
            LeftHolder leftHolder = (LeftHolder) holder;
            leftHolder.tvlefttitle.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getFilePathList()).into(leftHolder.ivleft1);
            leftHolder.tvleftrq.setText(list.get(position).getCreateTime());
        }
        if (itemViewType == 2){
            CenterHolder centerHolder = (CenterHolder) holder;
            centerHolder.tvcentertitle.setText(list.get(position).getTitle());
            centerHolder.tvcenterrq.setText(list.get(position).getCreateTime());
            Glide.with(context).load(list.get(position).getFilePathList().get(position).getFilePath()).into(centerHolder.ivcenter);
        }
        if (itemViewType == 3){
            RightHolder rightHolder = (RightHolder) holder;
            rightHolder.tvrighttitle.setText(list.get(position).getTitle());
            rightHolder.tvrightrq.setText(list.get(position).getCreateTime());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
       if (position%2==1){
           return 1;
       }else if (position %2==0){
           return 2;
       }
        return 3;
    }

    class LeftHolder extends RecyclerView.ViewHolder {
private TextView tvlefttitle;
private ImageView ivleft1;
private ImageView ivleft2;
private ImageView ivleft3;
private TextView tvleftrq;
        public LeftHolder(@NonNull View itemView) {
            super(itemView);
            tvlefttitle = itemView.findViewById(R.id.tv_left_title);
            tvleftrq = itemView.findViewById(R.id.tv_left_rq);
            ivleft1 = itemView.findViewById(R.id.iv_left1);
            ivleft2 = itemView.findViewById(R.id.iv_left2);
            ivleft3 = itemView.findViewById(R.id.iv_left3);
        }
    }

    class CenterHolder extends RecyclerView.ViewHolder {
private ImageView ivcenter;
private TextView tvcentertitle;
private TextView tvcenterrq;
        public CenterHolder(@NonNull View itemView) {
            super(itemView);
ivcenter = itemView.findViewById(R.id.iv_center);
tvcenterrq = itemView.findViewById(R.id.tv_center_rq);
tvcentertitle = itemView.findViewById(R.id.tv_center_title);
        }
    }

    class RightHolder extends RecyclerView.ViewHolder {
private TextView tvrighttitle;
private TextView tvrightrq;
        public RightHolder(@NonNull View itemView) {
            super(itemView);
            tvrightrq = itemView.findViewById(R.id.tv_right_rq);
            tvrighttitle = itemView.findViewById(R.id.tv_right_title);
        }
    }
}
