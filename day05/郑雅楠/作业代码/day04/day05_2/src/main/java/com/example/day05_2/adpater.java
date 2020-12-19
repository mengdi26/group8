package com.example.day05_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day05_2.bean.Info;

import java.util.ArrayList;

public class adpater extends RecyclerView.Adapter {
    private ArrayList<Info>list;
    private Context mContext;

    public adpater(ArrayList<Info> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
      if(position%2==0){
          return 2;
      }
      return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       if(viewType==1){
           View inflate = LayoutInflater.from(mContext).inflate(R.layout.lay_item, parent, false);
           return new HomeHolder(inflate);
       }
        View view = LayoutInflater.from(mContext).inflate(R.layout.lay_item, parent, false);
       return new HomeHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
          if(getItemViewType(position)==1){
              HomeHolder homeHolder= (HomeHolder) holder;
              homeHolder.tv.setText(list.get(position).getName());
              Glide.with(mContext).load(list.get(position).getPic()).apply(new RequestOptions().circleCrop()).into(homeHolder.img);

          }
          else {
              HomeHolder1 homeHolder1= (HomeHolder1) holder;
              homeHolder1.tv.setText(list.get(position).getName());
              Glide.with(mContext).load(list.get(position).getPic()).apply(new RequestOptions().circleCrop()).into(homeHolder1.img);

          }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class HomeHolder extends RecyclerView.ViewHolder{
private TextView tv;
private ImageView img;

        public HomeHolder(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
    class HomeHolder1 extends RecyclerView.ViewHolder{
        private TextView tv;
        private ImageView img;

        public HomeHolder1(@NonNull View itemView) {
            super(itemView);
            tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
        }
    }
}
