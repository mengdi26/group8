package com.example.day03_exam.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03_exam.R;
import com.example.day03_exam.Student;
import com.example.day03_exam.bean.TuijianBean;

import java.util.ArrayList;

public class RvAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Student> list;

    public RvAdpter(Context context, ArrayList<Student> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tuijian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TuijianRvAdpter.ViewHolder viewHolder = (TuijianRvAdpter.ViewHolder) holder;
        Student student = list.get(position);
        viewHolder.tv_text.setText(student.getString());
        Glide.with(context).load(student.getPic()).into(viewHolder.background);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView background;
        public TextView tv_text;
        public Button btn_go;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.background = (ImageView) rootView.findViewById(R.id.background);
            this.tv_text = (TextView) rootView.findViewById(R.id.tv_text);
            this.btn_go = (Button) rootView.findViewById(R.id.btn_go);
        }

    }
}
