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
import com.example.day03.bean.Info_Activity;
import com.example.day03.bean.Info_Navgation;
import com.example.day03.bean.Info_Type;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter {
    private ArrayList<Info_Activity.DataBean> hot;

    private Context mContext;

    public RvAdapter(ArrayList<Info_Activity.DataBean> hot, Context context) {
        this.hot = hot;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.lay_activity, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
         HomeHolder homeHolder= (HomeHolder) holder;
         homeHolder.tv.setText(hot.get(position).getTitle());
        Glide.with(mContext).load(hot.get(position).getCover()).into(homeHolder.img);
    }

    @Override
    public int getItemCount() {
        return hot.size();
    }
    class HomeHolder extends RecyclerView.ViewHolder{
private ImageView img;
private TextView tv;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
}
