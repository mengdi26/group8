package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class Myadaptersjk extends RecyclerView.Adapter<Myadaptersjk.ViewHolder> {
    ArrayList<MyBean.DataBeanX.DataBean> list;
    Context context;
    private DbUtil dbUtil;

    public Myadaptersjk(ArrayList<MyBean.DataBeanX.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.kkkk,parent,false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.tv1.setText(list.get(position).getTitle());
        if (list.get(position).getTitle()!=null){
            holder.tv2.setText(list.get(position).getIntro());
        }else {
            holder.tv2.setText("");
        }

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(context).load(list.get(position).getIcon()).apply(requestOptions).into(holder.im);
        holder.bu.setText("关注");
        holder.bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbUtil = DbUtil.getDbUtil();
                MyBean.DataBeanX.DataBean dataBean = list.get(position);
                MyDbBean myDbBean = new MyDbBean();
                myDbBean.setUrl(dataBean.getIcon());
                myDbBean.setTitle(dataBean.getTitle());
                myDbBean.setTitle1(dataBean.getIntro());
                long insert = dbUtil.insert(myDbBean);
                if (insert > 0) {
                   holder.bu.setText("以关注");
                } else {
                    List<MyDbBean> myDbBeans = dbUtil.selectSmart(myDbBean);
                    MyDbBean myDbBean1 = myDbBeans.get(position);
                    dbUtil.delete(myDbBean1);
                    holder.bu.setText("关注");

                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ioclick.paa(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView im;
        TextView tv1;
        TextView tv2;
        Button bu;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            im=itemView.findViewById(R.id.im);
            tv1=itemView.findViewById(R.id.tv1);
            tv2=itemView.findViewById(R.id.tv2);
            bu=itemView.findViewById(R.id.bu);
        }
    }
    public interface Ioclick{
        void paa(int pos);
    }
    Myadaptersjkk.Ioclick ioclick;

    public void setIoclick(Myadaptersjkk.Ioclick ioclick) {
        this.ioclick = ioclick;
    }
}
