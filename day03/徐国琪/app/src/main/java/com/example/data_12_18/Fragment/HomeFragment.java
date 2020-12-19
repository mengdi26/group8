package com.example.data_12_18.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.data_12_18.Adapter.RmhdAdapter;
import com.example.data_12_18.ApiService;
import com.example.data_12_18.Bean.RmhdBean;
import com.example.data_12_18.MainActivity2;
import com.example.data_12_18.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends Fragment {


    private TabLayout mTl;
    private ViewPager mVp;
    private ImageView mIva;
    private ImageView mIvb;
    private ImageView mIvc;
    private RecyclerView mRv;
    private List<RmhdBean.DataBean> list1;
    private RmhdAdapter rmhdAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initView(root);
        initData();
        // Inflate the layout for this fragment
        return root;
    }

    private void initData() {
        new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiService.baseUrlrmhd)
                .build()
                .create(ApiService.class)
                .getrmhd()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RmhdBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RmhdBean rmhdBean) {
                        List<RmhdBean.DataBean> data = rmhdBean.getData();
                        list1.addAll(data);
                        rmhdAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View root) {
        mTl = (TabLayout) root.findViewById(R.id.tl);
        mVp = (ViewPager) root.findViewById(R.id.vp);
        mIva = (ImageView) root.findViewById(R.id.iva);
        mIvb = (ImageView) root.findViewById(R.id.ivb);
        mIvc = (ImageView) root.findViewById(R.id.ivc);
        mRv = (RecyclerView) root.findViewById(R.id.rv);
        mIva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        mIvb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        mIvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });
        List<Fragment> list = new ArrayList<>();
        list.add(new CallFragment());
        list.add(new ZLFragment());
        list.add(new TsFragment());
        list.add(new TsFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        mTl.setupWithViewPager(mVp);
        mTl.getTabAt(0).setText("热点");
        mTl.getTabAt(1).setText("妆造");
        mTl.getTabAt(2).setText("图赏");
        mTl.getTabAt(3).setText("百科");
        list1 = new ArrayList<>();
        mRv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        rmhdAdapter = new RmhdAdapter(getActivity(), list1);
        mRv.setAdapter(rmhdAdapter);
    }
}