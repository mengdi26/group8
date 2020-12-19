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

import java.util.ArrayList;

public class Myadapter3 extends RecyclerView.Adapter {
    ArrayList<TsBean.DataBean.ListBean> list;
    Context context;

    public Myadapter3(ArrayList<TsBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        if (position==0){
            return 0;
        }else if (position==1){
            return 1;
        }else {
            return 2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0){
            View root= LayoutInflater.from(context).inflate(R.layout.k,parent,false);
            return new ViewHolder(root);
        }else if (viewType==1) {
            View root = LayoutInflater.from(context).inflate(R.layout.kkk, parent, false);
            return new TextViewHolder(root);
        }else {
            View root = LayoutInflater.from(context).inflate(R.layout.kkkk, parent, false);
            return new ImgViewHolder(root);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
              ViewHolder viewHolder= (ViewHolder) holder;
              viewHolder.tv.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getFilePathList().get(0)).into(viewHolder.im);
                Glide.with(context).load(list.get(position).getFilePathList().get(1)).into(viewHolder.im1);
                Glide.with(context).load(list.get(position).getFilePathList().get(2)).into(viewHolder.im2);
                break;
            case 1:
                TextViewHolder textViewHolder= (TextViewHolder) holder;
                textViewHolder.tv.setText(list.get(position).getTitle());
                textViewHolder.tv1.setText(list.get(position).getTitle());
                Glide.with(context).load(list.get(position).getFilePathList().get(0)).into(textViewHolder.im);
                break;
            case 2:
                ImgViewHolder imgViewHolder= (ImgViewHolder) holder;
                imgViewHolder.tv.setText(list.get(position).getTitle());
                imgViewHolder.tv1.setText(list.get(position).getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView im;
        ImageView im1;
        ImageView im2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            im=itemView.findViewById(R.id.im);
            im1=itemView.findViewById(R.id.im1);
            im2=itemView.findViewById(R.id.im2);
        }
    }
    public class TextViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        ImageView im;
        public TextViewHolder(@NonNull View itemView) {

            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
            im=itemView.findViewById(R.id.im);
        }
    }
    public class ImgViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        TextView tv1;
        public ImgViewHolder(@NonNull View itemView) {

            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            tv1=itemView.findViewById(R.id.tv1);
        }
    }
}
