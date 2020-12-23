package com.example.day06.mvp.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BaiduMapOptions;
import com.baidu.mapapi.map.MapView;
import com.example.day06.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

public class BaiduMapAcitvity extends AppCompatActivity  {


    @BindView(R.id.btn_1)
    RadioButton btn1;
    @BindView(R.id.btn_2)
    RadioButton btn2;
    @BindView(R.id.btn_3)
    RadioButton btn3;
    @BindView(R.id.btn_4)
    RadioButton btn4;
    @BindView(R.id.bmapView)
    MapView bmapView;
    private MapView mMapView = null;
    private BaiduMap mMap;
    private RadioButton btn_1;
    private RadioButton btn_2;
    private RadioButton btn_3;
    private RadioButton btn_4;
    private Unbinder mBind;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dt);
        ButterKnife.bind(this);
        initView();
        initPermission();
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);

        mMapView = findViewById(R.id.bmapView);
        mMap = mMapView.getMap();
//        final BaiduMapOptions options = new BaiduMapOptions();
//        options.mapType(BaiduMap.MAP_TYPE_SATELLITE);
//        final MapView mapView = new MapView(this, options);
//        setContentView(mapView);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
        mBind.unbind();

    }

    private void initPermission() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE
        });
    }

    private void initView() {
        btn_1 = (RadioButton) findViewById(R.id.btn_1);
        btn_2 = (RadioButton) findViewById(R.id.btn_2);
        btn_3 = (RadioButton) findViewById(R.id.btn_3);
        btn_4 = (RadioButton) findViewById(R.id.btn_4);
        bmapView = (MapView) findViewById(R.id.bmapView);
        //兰姆达项目表达式
//        btn_1.setOnCheckedChangeListener(((compoundButton, b) -> {
//
//        }));

    }

    @OnCheckedChanged({R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4})
    public void onCehcedChange(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.btn_1:
//普通地图
                mMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.btn_2:
//卫星地图
                mMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.btn_3:
//热力图
                mMap.setBaiduHeatMapEnabled(true);
                break;
            case R.id.btn_4:
//交通图
                mMap.setTrafficEnabled(true);
                break;
        }
    }


}
