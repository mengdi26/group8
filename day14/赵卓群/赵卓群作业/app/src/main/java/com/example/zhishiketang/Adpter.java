package com.example.zhishiketang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class Adpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Integer> list;

    public Adpter(Context context, ArrayList<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
            return new One(view);
        }
        if (viewType == 1) {
            View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
            return new Two(view);
        }
        if (viewType == 2) {
            View view = LayoutInflater.from(context).inflate(R.layout.item3, parent, false);
            return new Three(view);
        }
        if (viewType == 3) {
            View view = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
            return new Four(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int itemViewType = getItemViewType(position);
        if(itemViewType==1){
            One one = (One) holder;
            one.banner.setImages(list);
            one.banner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(context).load(path).into(imageView);
                }
            }).start();
        }
//        if (itemViewType == 3) {
//            Three three = (Three) holder;
//            ArrayList<Integer> integers = new ArrayList<>();
//            integers.add(R.drawable.t1);
//            integers.add(R.drawable.t2);
//            integers.add(R.drawable.t3);
//            integers.add(R.drawable.t4);
//            three.rv_main.setAdapter(new Rv1Adpter(context, list));
//        }
//        if (itemViewType == 4) {
//            Four four = (Four) holder;
//            ArrayList<Integer> integers2 = new ArrayList<>();
//            integers2.add(R.drawable.t1);
//            integers2.add(R.drawable.t2);
//            integers2.add(R.drawable.t3);
//            integers2.add(R.drawable.t4);
//            four.rv_main.setAdapter(new Rv1Adpter(context, list));
//        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 4;
    }




    public static
    class One extends RecyclerView.ViewHolder {
        public View rootView;
        public Banner banner;
        public ImageView image1;
        public ImageView image2;
        public ImageView image3;
        public ImageView image4;

        public One(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.banner = (Banner) rootView.findViewById(R.id.banner);
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
            this.image2 = (ImageView) rootView.findViewById(R.id.image2);
            this.image3 = (ImageView) rootView.findViewById(R.id.image3);
            this.image4 = (ImageView) rootView.findViewById(R.id.image4);
        }

    }

    class Two extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv;
        public ImageView image1;

        public Two(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.image1 = (ImageView) rootView.findViewById(R.id.image1);
        }

    }

    class Three extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv;
        public RecyclerView rv_main;
        public TextView tv_1;

        public Three(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.rv_main = (RecyclerView) rootView.findViewById(R.id.rv_main);
            this.tv_1 = (TextView) rootView.findViewById(R.id.tv_1);
        }

    }

    class Four extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv;
        public RecyclerView rv_main;

        public Four(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.rv_main = (RecyclerView) rootView.findViewById(R.id.rv_main);
        }

    }
}
