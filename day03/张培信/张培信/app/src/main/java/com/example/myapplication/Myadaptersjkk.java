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

import java.util.ArrayList;

public class Myadaptersjkk extends RecyclerView.Adapter<Myadaptersjkk.ViewHolder> {
    ArrayList<MyDbBean> list;
    Context context;

    public Myadaptersjkk(ArrayList<MyDbBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.kkkk,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tv1.setText(list.get(position).getTitle1());
        holder.tv2.setText(list.get(position).getTitle());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(list.get(position).getUrl()).apply(requestOptions).into(holder.im);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ioclick.paa(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tv1;
        TextView tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
        }
    }
    public interface Ioclick{
        void paa(int pos);
    }
    Ioclick ioclick;

    public void setIoclick(Ioclick ioclick) {
        this.ioclick = ioclick;
    }
}
