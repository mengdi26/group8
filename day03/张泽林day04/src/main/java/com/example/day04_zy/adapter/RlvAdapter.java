package com.example.day04_zy.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day04_zy.R;
import com.example.day04_zy.bean.Bean;

import java.util.ArrayList;

public class RlvAdapter extends RecyclerView.Adapter {


    private int ONE = 1;
    private int Second = 2;
    private int Tree = 3;
    private ArrayList<Bean.DataBean> list;
    private Context context;

    public RlvAdapter(ArrayList<Bean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == ONE) {
            view = LayoutInflater.from(context).inflate(R.layout.item_a, parent, false);
            return new Remen(view);
        }
        view = LayoutInflater.from(context).inflate(R.layout.item_b, parent, false);
        return new Rtu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        Bean.DataBean dataBean = list.get(position);
        if (type == ONE){
            Remen remen = (Remen) holder;
            remen.tv_r1.setText("热门活动");
            remen.tv_r2.setText("更多活动 >");
            remen.tv_r2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        }
        if (type == Second){
            Rtu rtu = (Rtu) holder;
            Glide.with(context).load(dataBean.getCover()).into(rtu.iv_r1);
            rtu.tv_r3.setText(dataBean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ONE;
        }
        if (position == 1) {
            return Second;
        }
        return Tree;
    }

    public static
    class Remen extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_r1;
        public TextView tv_r2;

        public Remen(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_r1 = (TextView) rootView.findViewById(R.id.tv_r1);
            this.tv_r2 = (TextView) rootView.findViewById(R.id.tv_r2);
        }

    }

    public static
    class Rtu extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_r1;
        public TextView tv_r3;

        public Rtu(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_r1 = (ImageView) rootView.findViewById(R.id.iv_r1);
            this.tv_r3 = (TextView) rootView.findViewById(R.id.tv_r3);
        }

    }
}
