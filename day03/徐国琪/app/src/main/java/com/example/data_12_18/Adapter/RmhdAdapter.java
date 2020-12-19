package com.example.data_12_18.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.data_12_18.Bean.RmhdBean;
import com.example.data_12_18.R;

import java.util.List;

public class RmhdAdapter extends RecyclerView.Adapter<RmhdAdapter.ViewHolder> {
    private Context context;
    private List<RmhdBean.DataBean> list1;


    public RmhdAdapter(Context context, List<RmhdBean.DataBean> list1) {

        this.context = context;
        this.list1 = list1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.rmhd_item, parent, false);
        return new ViewHolder(root);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RmhdBean.DataBean dataBean = list1.get(position);
        Glide.with(context).load(dataBean.getCover()).into(holder.mIv);
        holder.mTva.setText(dataBean.getTitle());
        holder.mTvb.setText(dataBean.getLocation());
        holder.mTvc.setText(dataBean.getStartTime());
    }

    @Override
    public int getItemCount() {
        return list1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mIv;
         TextView mTva;
         TextView mTvb;
         TextView mTvc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
            mTva = (TextView) itemView.findViewById(R.id.tva);
            mTvb = (TextView) itemView.findViewById(R.id.tvb);
            mTvc = (TextView) itemView.findViewById(R.id.tvc);
        }
    }
}
