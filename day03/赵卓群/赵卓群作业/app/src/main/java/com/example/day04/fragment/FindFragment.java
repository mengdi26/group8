package com.example.day04.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.day04.ApiService;
import com.example.day04.R;
import com.example.day04.adpter.LogIntCeptor;
import com.example.day04.adpter.RvAdpter;
import com.example.day04.adpter.VpAdpter;
import com.example.day04.bean.FenleiBean;
import com.example.day04.bean.HotBean;
import com.example.day04.fragment2.RedianFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class FindFragment extends Fragment {

    private Toolbar toolbar;
    private ImageView iv_image1;
    private ImageView iv_image2;
    private ImageView iv_image3;
    private TextView tv_text1;
    private TextView tv_text2;
    private TextView tv_text3;
    private TextView tv_remen;
    private TextView tv_long;
    private RecyclerView rv_main;
    private TabLayout tab;
    private ViewPager vp;
    private ConstraintLayout cl_main;
    private ArrayList<HotBean.DataBean> list;
    private RvAdpter adpter;
    private ArrayList<FenleiBean.DataBean> list1;
    private VpAdpter adpter1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        OkHttpClient build = new OkHttpClient.Builder()
                .addInterceptor(new LogIntCeptor())
                .build();
        new Retrofit.Builder()
                .client(build)
                .baseUrl(ApiService.BESA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getHot()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotBean value) {
                        List<HotBean.DataBean> data = value.getData();
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
        initData1();
    }

    private void initView(View view) {
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("发现");
        toolbar.setTitleMargin(300, 0, 0, 0);
        rv_main = view.findViewById(R.id.rv_main);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        rv_main.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        adpter = new RvAdpter(getContext(), list);
        rv_main.setAdapter(adpter);
        tab=view.findViewById(R.id.tab);
        vp=view.findViewById(R.id.vp);
        list1 = new ArrayList<>();


    }
    private void initData1() {
        OkHttpClient build = new OkHttpClient.Builder()
                .addInterceptor(new LogIntCeptor())
                .build();
        new Retrofit.Builder()
                .client(build)
                .baseUrl(ApiService.BESA_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getFen()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FenleiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FenleiBean value) {
                        List<FenleiBean.DataBean> data = value.getData();
                        list1.addAll(data);
                        ArrayList<Fragment> fragments = new ArrayList<>();
                        for (int i = 0; i < list1.size(); i++) {
                            RedianFragment redianFragment = new RedianFragment();
                            Bundle bundle = new Bundle();
                            bundle.putInt("id",list1.get(i).getType());
                            redianFragment.setArguments(bundle);
                            fragments.add(redianFragment);
                        }
                        adpter1 = new VpAdpter(getChildFragmentManager(),fragments, list1);
                        vp.setAdapter(adpter1);
                        tab.setupWithViewPager(vp);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}