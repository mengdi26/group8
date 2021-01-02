package com.example.day10.adpter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day10.BeanApp;
import com.example.day10.R;
import com.example.day10.mvp.model.bean.DatasBean;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DbAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<DatasBean> list;

    public DbAdapter(Context context, ArrayList<DatasBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    private OnChecked onChecked;

    public void setOnChecked(OnChecked onChecked) {
        this.onChecked = onChecked;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        DatasBean bean = list.get(position);
        viewHolder.tvDesc.setText(bean.getDesc());
        viewHolder.butBox.setChecked(bean.getCollect());
        Glide.with(context).load(bean.getEnvelopePic()).into(viewHolder.ivEnvelopePic);

        viewHolder.butBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isPressed()) {
                    list.get(position).setCollect(false);
                    onChecked.OnCheckedListener(position);
                }
            }
        });
    }

    public interface OnChecked {
        void OnCheckedListener(int p);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_envelopePic)
        ImageView ivEnvelopePic;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.but_box)
        CheckBox butBox;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
