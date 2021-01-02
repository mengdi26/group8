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
import com.example.day10.R;
import com.example.day10.mvp.model.bean.DatasBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<DatasBean> list;

    public ItemAdapter(Context context, ArrayList<DatasBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_home, parent, false);
        return new ViewHolder(view);
    }

    private int pos;

    public int getPos() {
        return pos;
    }

    private OnCheckedChange onCheckedChange;

    public void setOnCheckedChange(OnCheckedChange onCheckedChange) {
        this.onCheckedChange = onCheckedChange;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        DatasBean bean = list.get(position);
        viewHolder.tvDesc.setText(bean.getDesc());
        viewHolder.butBox.setChecked(bean.getCollect());
        Glide.with(context).load(bean.getEnvelopePic()).into(viewHolder.ivEnvelopePic);

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pos = position;
                return false;
            }
        });

        viewHolder.butBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isPressed()){
                    if (!list.get(position).getCollect()){
                        list.get(position).setCollect(true);
                        onCheckedChange.OnCheckedChangeListener(list.get(position).getCollect(),position);
                    }else {
                        list.get(position).setCollect(!list.get(position).getCollect());
                        onCheckedChange.OnCheckedChangeListener(list.get(position).getCollect(),position);
                    }
                    notifyDataSetChanged();
                }
            }
        });
    }

    public interface OnCheckedChange{
        void OnCheckedChangeListener(boolean ok,int p);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        @BindView(R.id.iv_envelopePic)
        ImageView ivEnvelopePic;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.but_box)
        CheckBox butBox;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0,0,0,"发送通知");
            menu.add(0,1,0,"弹个pop");

        }
    }
}
