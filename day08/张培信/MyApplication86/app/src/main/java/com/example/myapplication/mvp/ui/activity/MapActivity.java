package com.example.myapplication.mvp.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.example.myapplication.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

public class MapActivity extends AppCompatActivity implements View.OnClickListener {


    private RadioButton mBu1;
    private RadioButton mBu2;
    private RadioButton mBu3;
    private RadioButton mBu4;
    private RadioGroup mRg;
    private BaiduMap mBaiduMap;
    private MapView mBmapView = null;
    private LocationClient locationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initView();
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {
                kk();
            }



            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION});

        //获取地图控件引用

    }

    private void initView() {
        mBu1 = (RadioButton) findViewById(R.id.bu1);
        mBu2 = (RadioButton) findViewById(R.id.bu2);
        mBu3 = (RadioButton) findViewById(R.id.bu3);
        mBu4 = (RadioButton) findViewById(R.id.bu4);
       mBmapView = (MapView) findViewById(R.id.bmapView);
        mBmapView.setOnClickListener(this);

        mBaiduMap = mBmapView.getMap();
//普通地图 ,mBaiduMap是地图控制器对象
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        mBaiduMap.setMyLocationEnabled(true);
        mRg = (RadioGroup) findViewById(R.id.rg);
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){
                    case R.id.bu1:
                        mBmapView = (MapView) findViewById(R.id.bmapView);
                        mBaiduMap = mBmapView.getMap();
//卫星地图
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                        break;
                    case R.id.bu2:
                        mBmapView = (MapView) findViewById(R.id.bmapView);
                        mBaiduMap = mBmapView.getMap();
//空白地图
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NONE);
                        break;
                    case R.id.bu3:
                        mBmapView = (MapView) findViewById(R.id.bmapView);
                        mBaiduMap = mBmapView.getMap();
//开启热力图

                        mBaiduMap.setBaiduHeatMapEnabled(true);
                        break;
                    case R.id.bu4:
                        mBmapView = (MapView) findViewById(R.id.bmapView);
                        mBaiduMap = mBmapView.getMap();
//开启交通图
                        mBaiduMap.setBaiduHeatMapEnabled(false);
                        mBaiduMap.setTrafficEnabled(true);

                        break;

                }
            }
        });
    }

    @Override
    protected void onResume() {
        mBmapView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mBmapView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        locationClient.stop();
        mBaiduMap.setMyLocationEnabled(false);
        mBmapView.onDestroy();
        mBmapView = null;
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bmapView:
                // TODO 20/12/23
                break;
            default:
                break;
        }
    }
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mBmapView == null){
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
    public void kk(){
        //定位初始化
        locationClient = new LocationClient(this);

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        locationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        locationClient.registerLocationListener(myLocationListener);

        //初始化点聚合管理类


//ClusterItem接口的实现类

//开启地图定位图层
        locationClient.start();
    }  j'j'

//初始化点聚合管理类
    mClusterManager = new ClusterManager<MyItem>(this, mBaiduMap);
 不够好
    //ClusterItem接口的实现类
    public class MyItem implements ClusterItem {
        LatLng mPosition;
        public MyItem(LatLng position) {
            mPosition = position;
        }
        @Override
        public LatLng getPosition() {
            return mPosition;
        }
        @Override
        public BitmapDescriptor getBitmapDescriptor() {
            return BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_gcoding);
        }
    }
    // 添加Marker点448
    LatLng llA = new LatLng(39.963175, 116.400244);
    LatLng llB = new LatLng(39.942821, 116.369199);
    List<MyItem> items = new ArrayList<MyItem>();
items.add(new MyItem(llA));
items.add(new MyItem(llB));
mClusterManager.addItems(items);

}