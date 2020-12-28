package com.example.jpull_text;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CallAdater extends RecyclerView.Adapter<CallAdater.ViewHolder> {
    private Context context;
    private List<Integer> lista;

    public CallAdater(Context context, List<Integer> lista) {

        this.context = context;
        this.lista = lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_item, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Integer integer = lista.get(position);
        Glide.with(context).load(integer).into(holder.mIv);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView mIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }
}
