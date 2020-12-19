package com.example.day03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day03.R;
import com.example.day03.bean.Info_Type;

import java.nio.file.Path;
import java.util.ArrayList;

public class ThreeAdapter extends RecyclerView.Adapter {
    private ArrayList<Info_Type.DataBean.ListBean>mList;
    private Context mContext;
    private ArrayList<Info_Type.DataBean.ListBean.FilePathListBean>file;



    public ThreeAdapter(ArrayList<Info_Type.DataBean.ListBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
      if(position%2==0){
          return 1;
      }
      return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      if(viewType==1){
          View inflate = LayoutInflater.from(mContext).inflate(R.layout.three_item1, parent, false);
          return new HomeHolder(inflate);
      }
        View view = LayoutInflater.from(mContext).inflate(R.layout.three_item2, parent, false);
        return new HomeHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==1){
            HomeHolder homeHolder= (HomeHolder) holder;
            homeHolder.tv.setText(mList.get(position).getTitle());
            Glide.with(mContext).load(mList.get(position).getFilePathList()).into(homeHolder.img_1);
            Glide.with(mContext).load(mList.get(position).getFilePathList()).into(homeHolder.img_2);
            Glide.with(mContext).load(mList.get(position).getFilePathList()).into(homeHolder.img_3);
        }
        else {
            HomeHolder1 homeHolder1= (HomeHolder1) holder;
            homeHolder1.tv.setText(mList.get(position).getTitle());
          Glide.with(mContext).load(mList.get(position).getFilePathList()).into(homeHolder1.img);
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    class HomeHolder extends RecyclerView.ViewHolder{
private ImageView img_1;
        private ImageView img_2;
        private ImageView img_3;
        private TextView tv;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            img_1=itemView.findViewById(R.id.img_1);
            img_2=itemView.findViewById(R.id.img_2);
            img_3=itemView.findViewById(R.id.img_3);
            tv=itemView.findViewById(R.id.tv);

        }
    }
    class HomeHolder1 extends RecyclerView.ViewHolder{
        private ImageView img;

        private TextView tv;

        public HomeHolder1(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);

            tv=itemView.findViewById(R.id.tv);

        }
    }
}
