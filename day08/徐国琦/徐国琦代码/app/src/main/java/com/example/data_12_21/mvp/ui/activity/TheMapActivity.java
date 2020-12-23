package com.example.data_12_21.mvp.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.example.data_12_21.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

public class TheMapActivity extends Activity  {
    private MapView mMapView = null;
    private RadioButton rba;
    private RadioButton rbb;
    private RadioButton rbc;
    private RadioGroup rg;
    private RadioButton rbd;
    private MapView bmapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themap_activity);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        initView();

        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {


                initData();
            }
            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION);

    }

    private void initData() {
        //定位初始化
        mLocationClient = new LocationClient(this);

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();
    }

    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    private void initView() {
        rba = (RadioButton) findViewById(R.id.rba);
        rbb = (RadioButton) findViewById(R.id.rbb);
        rbc = (RadioButton) findViewById(R.id.rbc);
        rbd = (RadioButton) findViewById(R.id.rbd);
        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rba:
                        BaiduMap mBaiduMap = mMapView.getMap();
                        //普通地图 ,mBaiduMap是地图控制器对象
                        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setTrafficEnabled(false);
                        break;
                    case R.id.rbb:
                        mBaiduMap = mMapView.getMap();
                        //卫星地图
                        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setTrafficEnabled(false);
                        break;
                    case R.id.rbc:
                        mBaiduMap = mMapView.getMap();
                        //开启热力图
                        mBaiduMap.setTrafficEnabled(false);
                        mBaiduMap.setBaiduHeatMapEnabled(true);
                        break;
                    case R.id.rbd:
                        mBaiduMap = mMapView.getMap();
                            //开启交通图
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setTrafficEnabled(true);
                        break;
                }
            }
        });
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
        }
    }
}
