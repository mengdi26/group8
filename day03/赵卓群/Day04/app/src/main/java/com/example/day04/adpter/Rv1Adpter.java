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
import com.example.day04.bean.TypeBean;

import java.util.ArrayList;

public class Rv1Adpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TypeBean.DataBean.ListBean> list;

    public Rv1Adpter(Context context, ArrayList<TypeBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_11, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        TypeBean.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getFilePathList().get(position).getFilePath()).into(viewHolder.iv_image);
        viewHolder.text.setText(listBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView text;
        public ImageView iv_image;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.text = (TextView) rootView.findViewById(R.id.text);
            this.iv_image = (ImageView) rootView.findViewById(R.id.iv_image);
        }

    }
}
