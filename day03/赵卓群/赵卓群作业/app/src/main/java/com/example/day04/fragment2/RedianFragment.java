package com.example.day04.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day04.ApiService;
import com.example.day04.R;
import com.example.day04.adpter.Rv1Adpter;
import com.example.day04.bean.TypeBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RedianFragment extends Fragment {

    private RecyclerView rv_main;
    private ArrayList<TypeBean.DataBean.ListBean> list;
    private Rv1Adpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_redian, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        Bundle arguments = getArguments();
        int id = arguments.getInt("id");
        new Retrofit.Builder()
                .baseUrl(ApiService.BESA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getType(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TypeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TypeBean value) {
                        List<TypeBean.DataBean.ListBean> list = value.getData().getList();
                        list.addAll(list);
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
        rv_main.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adpter = new Rv1Adpter(getContext(), list);
        rv_main.setAdapter(adpter);
    }
}