package com.example.data_12_18.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.data_12_18.Adapter.RdAdapter;
import com.example.data_12_18.ApiService;
import com.example.data_12_18.Bean.Typeyi;
import com.example.data_12_18.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CallFragment extends Fragment {


    private RecyclerView mRv;
    private RdAdapter rdAdapter;
    private List<Typeyi.DataBean.ListBean> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_call, container, false);
        initView(root);
        initData();
        // Inflate the layout for this fragment
        return root;
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiService.baseUrlrd)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getyi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Typeyi>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Typeyi typeyi) {
                        List<Typeyi.DataBean.ListBean> list = typeyi.getData().getList();
                        list.addAll(list);
                        rdAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(View root) {
        list = new ArrayList<>();
        mRv = (RecyclerView) root.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));
        rdAdapter = new RdAdapter(list, getActivity());
        mRv.setAdapter(rdAdapter);
    }
}