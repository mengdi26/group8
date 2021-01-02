package com.example.day10.mvp.ui.fragment;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.example.day10.R;
import com.example.day10.base.BaseFragment;
import com.example.day10.base.BasePresenter;
import com.example.day10.mvp.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class BlankFragment3 extends BaseFragment {


    @BindView(R.id.map_frag3)
    MapView mMapView;
    private BaiduMap mBaiduMap;
    private LocationClient mLocationClient;

    @Override
    protected void init() {

        //添加这下面的一部分
//动态申请权限
        List<String> permissionList = new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String[] permissions =permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(getActivity(), permissions, 1);
        }


        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);
        initMap();
    }

    private void initMap() {
        //定位初始化
        mLocationClient = new LocationClient(getContext());

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
    protected void initData() {

    }

    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
    @Override
    public void onDestroy() {
        mLocationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank3;
    }

    @Override
    public void getData(Object o) {
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
