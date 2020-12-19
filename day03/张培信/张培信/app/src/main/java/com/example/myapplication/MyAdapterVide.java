package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yc.video.player.VideoPlayer;
import com.yc.video.ui.view.BasisVideoController;

import java.util.ArrayList;

public class MyAdapterVide extends RecyclerView.Adapter<MyAdapterVide.ViewHolder> {
    ArrayList<ShipingJava.DataBeanX.DataBean> list;
    Context context;

    public MyAdapterVide(ArrayList<ShipingJava.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapterVide.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.kk,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterVide.ViewHolder holder, int position) {
        holder.tv1.setText(list.get(position).getId()+"");
        holder.tv.setText(list.get(position).getAuthor().getName());
        holder.tv2.setText(list.get(position).getId()+"");
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(list.get(position).getAuthor().getAvatar()).apply(requestOptions).into(holder.im);


        //创建基础视频播放器，一般播放器的功能
        BasisVideoController controller = new BasisVideoController(context);
//设置控制器
        holder.mPlayerVideo.setController(controller);
//设置视频播放链接地址
        holder.mPlayerVideo.setUrl(list.get(position).getUrl());
//开始播放
        holder. mPlayerVideo.start();
        holder.mPlayerVideo.postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.mPlayerVideo.start();
            }
        }, 300);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
         VideoPlayer mPlayerVideo;
        TextView tv;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            mPlayerVideo = itemView. findViewById(R.id.im1);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
}
