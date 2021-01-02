package com.example.newyear.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newyear.R;
import com.example.newyear.mvp.model.bean.Data;

import java.util.ArrayList;

public class RelAdapter extends RecyclerView.Adapter {
    private ArrayList<Data>list;
    private Context mContext;

    public RelAdapter(ArrayList<Data> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.lay_item, parent, false);
        return new HomeHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
      HomeHolder homeHolder= (HomeHolder) holder;
      homeHolder.tv.setText(list.get(position).getTitle());
        Glide.with(mContext).load(list.get(position).getImg()).into(homeHolder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HomeHolder extends RecyclerView.ViewHolder{
private TextView tv;
private ImageView img;
        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
}
