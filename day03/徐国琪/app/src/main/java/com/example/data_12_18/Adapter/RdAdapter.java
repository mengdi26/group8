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
import com.example.data_12_18.Bean.Typeyi;
import com.example.data_12_18.R;

import java.util.List;

public class RdAdapter extends RecyclerView.Adapter {
    private List<Typeyi.DataBean.ListBean> list;
    private Context context;
    private static final int SAN_TYPE = 0;
    private static final int ZZYW_TYPE = 1;
    private static final int TEXT_TYPE = 2;



    public RdAdapter(List<Typeyi.DataBean.ListBean> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 1) {
            return SAN_TYPE;
        } else if (position % 3 == 2) {
            return ZZYW_TYPE;
        } else {
            return TEXT_TYPE;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == SAN_TYPE) {
            View root = LayoutInflater.from(context).inflate(R.layout.san_item, parent, false);
            return new SanViewHolder(root);
        } else if (viewType == ZZYW_TYPE) {
            View root = LayoutInflater.from(context).inflate(R.layout.zzyw_item, parent, false);
            return new ZzywHolder(root);
        } else {
            View root = LayoutInflater.from(context).inflate(R.layout.text_item, parent, false);
            return new TextHolder(root);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Typeyi.DataBean.ListBean listBean = list.get(position);
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case SAN_TYPE:
                SanViewHolder sanViewHolder = (SanViewHolder) holder;
                sanViewHolder.mTv.setText(listBean.getTitle());
                Glide.with(context).load(listBean.getFilePathList().get(0)).into(sanViewHolder.mIva);
                Glide.with(context).load(listBean.getFilePathList().get(1)).into(sanViewHolder.mIva);
                Glide.with(context).load(listBean.getFilePathList().get(2)).into(sanViewHolder.mIva);
                break;
            case ZZYW_TYPE:
                ZzywHolder zzywHolder = (ZzywHolder) holder;
                zzywHolder.mTv.setText(listBean.getTitle());
                Glide.with(context).load(listBean.getFilePathList().get(0)).into(zzywHolder.mIv);
                break;
            case TEXT_TYPE:
                TextHolder textHolder = (TextHolder) holder;
                textHolder.mTv.setText(listBean.getTitle());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class SanViewHolder extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIva;
        ImageView mIvb;
        ImageView mIvc;

        public SanViewHolder(View root) {
            super(root);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mIva = (ImageView) itemView.findViewById(R.id.iva);
            mIvb = (ImageView) itemView.findViewById(R.id.ivb);
            mIvc = (ImageView) itemView.findViewById(R.id.ivc);
        }
    }

    private class ZzywHolder extends RecyclerView.ViewHolder {
        TextView mTv;
        ImageView mIv;

        public ZzywHolder(View root) {
            super(root);
            mTv = (TextView) itemView.findViewById(R.id.tv);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    private class TextHolder extends RecyclerView.ViewHolder {
        TextView mTv;
        public TextHolder(View root) {
            super(root);
            mTv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
