package com.example.day10.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day10.R;
import com.example.day10.mvp.model.bean.FuLiBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FuLiAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<FuLiBean.ResultsBean> list;

    public FuLiAdapter(Context context, ArrayList<FuLiBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        FuLiBean.ResultsBean bean = list.get(position);
        viewHolder.tvId.setText(bean.get_id());
        Glide.with(context).load(bean.getUrl()).into(viewHolder.ivUrl);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_url)
        ImageView ivUrl;
        @BindView(R.id.tv_id)
        TextView tvId;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
