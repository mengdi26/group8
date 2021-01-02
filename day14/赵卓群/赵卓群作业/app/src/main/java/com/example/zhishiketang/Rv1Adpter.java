package com.example.zhishiketang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Rv1Adpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> integers;

    public Rv1Adpter(Context context, ArrayList<Integer> integers) {
        this.context = context;
        this.integers = integers;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item5, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return integers.size();
    }
}
