package com.example.day10.mvp.ui.fragment;

import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day10.BeanApp;
import com.example.day10.R;
import com.example.day10.adpter.DbAdapter;
import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.model.bean.DatasBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class BlankFragment4 extends BaseFragment {


    @BindView(R.id.rec_frag4)
    RecyclerView recFrag4;
    private ArrayList<DatasBean> list;
    private DbAdapter adapter;

    @Override
    protected void init() {
        recFrag4.setLayoutManager(new LinearLayoutManager(getContext()));

        list = (ArrayList<DatasBean>) BeanApp.getMyBeanApp().getDaoSession().getDatasBeanDao().queryBuilder().list();
        adapter = new DbAdapter(getContext(), list);
        recFrag4.setAdapter(adapter);


    }


//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser){
//            init();
//            initData();
//            Log.e("TAG","run:"+"aaaaaaaaaaaaaaaaaaaaa");
//        }
//    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            init();
            initData();
        }
    }

    @Override
    protected void initData() {
       adapter.setOnChecked(new DbAdapter.OnChecked() {
           @Override
           public void OnCheckedListener(int p) {
               BeanApp.getMyBeanApp().getDaoSession().getDatasBeanDao().delete(list.get(p));
               list.remove(p);
               adapter.notifyDataSetChanged();
               Toast.makeText(getContext(), "删除", Toast.LENGTH_SHORT).show();

           }
       });

    }


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank4;
    }

    @Override
    public void getData(Object o) {

    }
}