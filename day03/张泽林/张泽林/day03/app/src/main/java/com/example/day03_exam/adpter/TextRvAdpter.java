package com.example.day03_exam.adpter;

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
import com.example.day03_exam.R;
import com.example.day03_exam.bean.TextBean;

import java.util.ArrayList;

public class TextRvAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TextBean.DataBeanX.DataBean> list;

    public TextRvAdpter(Context context, ArrayList<TextBean.DataBeanX.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        TextBean.DataBeanX.DataBean dataBean = list.get(position);
        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(new RequestOptions().circleCrop()).into(viewHolder.avatar);
        viewHolder.name.setText(dataBean.getAuthor().getName());
        viewHolder.feeds_text.setText(dataBean.getAuthor().getQqOpenId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView avatar;
        public TextView name;
        public TextView feeds_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.avatar = (ImageView) rootView.findViewById(R.id.avatar);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.feeds_text = (TextView) rootView.findViewById(R.id.feeds_text);
        }

    }
}
