package com.example.day03_exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_exam.ApiService;
import com.example.day03_exam.R;
import com.example.day03_exam.adpter.VideoRvAdpter;
import com.example.day03_exam.bean.VideoBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class VideoFragment extends Fragment {

    private RecyclerView rv_main;
    private ArrayList<VideoBean.DataBeanX.DataBean> list;
    private VideoRvAdpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getVideo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(VideoBean value) {
                        List<VideoBean.DataBeanX.DataBean> data = value.getData().getData();
                        list.addAll(data);
                        adpter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View view) {
        rv_main=view.findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_main.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();
        adpter = new VideoRvAdpter(getActivity(), list);
        rv_main.setAdapter(adpter);
    }
}