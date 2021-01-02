package com.example.day10.mvp.ui.fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day10.BeanApp;
import com.example.day10.R;
import com.example.day10.adpter.ItemAdapter;
import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.db.DatasBeanDao;
import com.example.day10.mvp.model.bean.DatasBean;
import com.example.day10.mvp.model.bean.ItemBean;
import com.example.day10.mvp.presenter.HomePresenter;
import com.example.day10.mvp.ui.activity.HomeActivity;

import java.util.ArrayList;

import butterknife.BindView;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.rec_home)
    RecyclerView recHome;
    private ArrayList<DatasBean> list;
    private ItemAdapter adapter;
    private int id;
    private boolean okk = false;

    @Override
    protected void init() {


        boolean ok = getActivity().getSharedPreferences("okk", Context.MODE_PRIVATE).getBoolean("ok", false);

        if (!ok){
            getRex();
        }


        DatasBeanDao db = BeanApp.getMyBeanApp().getDaoSession().getDatasBeanDao();

        Bundle arguments = getArguments();
        id = arguments.getInt("id");

        recHome.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        adapter = new ItemAdapter(getContext(), list);
        recHome.setAdapter(adapter);

        adapter.setOnCheckedChange(new ItemAdapter.OnCheckedChange() {
            @Override
            public void OnCheckedChangeListener(boolean ok,int p) {
                if (ok){
                    db.insertOrReplace(list.get(p));
                    Toast.makeText(getContext(), "收藏", Toast.LENGTH_SHORT).show();
                }else {
                    db.delete(list.get(p));
                    Toast.makeText(getContext(), "删除", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        okk = isVisibleToUser;
    }

    @Override
    protected void initData() {
        createPresenter().start(id);
    }

    private void getRex(){
        getActivity().getSharedPreferences("okk",Context.MODE_PRIVATE).edit().putBoolean("ok",true).commit();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int pos = adapter.getPos();
        if (okk) {
            switch (item.getItemId()) {
                case 0:
                    initTong(pos);
                    break;
                case 1:
                    initPop(pos);
                    break;
            }
        }
        return super.onContextItemSelected(item);
    }



    private void initPop(int pos) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.pop_item, null);
        PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(recHome, Gravity.BOTTOM,0,0);


        WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
        attributes.alpha = 0.4f;
        getActivity().getWindow().setAttributes(attributes);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                attributes.alpha = 1;
                getActivity().getWindow().setAttributes(attributes);
            }
        });


        EditText et_name = view.findViewById(R.id.et_name);

        view.findViewById(R.id.but_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_name.getText().toString();
                list.get(pos).setDesc(name);
                adapter.notifyDataSetChanged();

                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.but_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

    }

    private void initTong(int pos) {
        NotificationManager systemService = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        String Id = "0";
        String Name = "kc";
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(Id, Name, NotificationManager.IMPORTANCE_DEFAULT);
            systemService.createNotificationChannel(notificationChannel);
        }

        Intent intent = new Intent(getActivity(), HomeActivity.class);
        intent.putExtra("url",list.get(pos).getLink());
        PendingIntent activity = PendingIntent.getActivity(getContext(), 10, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        Notification notification = new NotificationCompat.Builder(getContext(), Id)
                .setContentTitle("通知")
                .setContentText("点击进入")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(activity)
                .setAutoCancel(true)
                .build();

        systemService.notify(20,notification);


    }

    @Override
    protected BasePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void getData(Object o) {
        ItemBean bean = (ItemBean) o;
        list.addAll(bean.getData().getDatas());
        adapter.notifyDataSetChanged();
    }
}