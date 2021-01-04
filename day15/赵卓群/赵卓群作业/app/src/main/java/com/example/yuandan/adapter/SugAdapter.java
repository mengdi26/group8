package com.example.yuandan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yuandan.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SugAdapter extends RecyclerView.Adapter {
    private final Context context;
    private final ArrayList<String> key;
    private final ArrayList<String> city;
    private final ArrayList<String> dis;

    public SugAdapter(Context context, ArrayList<String> key, ArrayList<String> city, ArrayList<String> dis) {

        this.context = context;
        this.key = key;
        this.city = city;
        this.dis = dis;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.sugKey.setText(key.get(position));
        viewHolder.sugCity.setText(city.get(position));
        viewHolder.sugDis.setText(dis.get(position));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.OnClickListener(position);
            }
        });

    }

    public interface OnClick {
        void OnClickListener(int pos);
    }

    @Override
    public int getItemCount() {
        return city.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.sug_key)
        TextView sugKey;
        @BindView(R.id.sug_city)
        TextView sugCity;
        @BindView(R.id.sug_dis)
        TextView sugDis;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
