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

public class TuijianRvAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<TuijianBean.DataBeanX.DataBean> list;

    public TuijianRvAdpter(Context context, ArrayList<TuijianBean.DataBeanX.DataBean> list) {
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
        ViewHolder viewHolder = (ViewHolder) holder;
        TuijianBean.DataBeanX.DataBean dataBean = list.get(position);
        viewHolder.tv_text.setText(dataBean.getTitle());
        Glide.with(context).load(dataBean.getBackground()).into(viewHolder.background);
        viewHolder.btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setId(null);
                student.setPic(list.get(position).getBackground());
                student.setString(list.get(position).getTitle());
            }
        });
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
