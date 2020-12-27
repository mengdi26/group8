package com.example.dt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;

public class QhDtActivity extends AppCompatActivity {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);

        //创建MapView对象
        MapView mapView1 = new MapView(this);
        //添加MapView对象
        setContentView(mapView1);

        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
//普通地图 ,mBaiduMap是地图控制器对象
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
//       //定义BaiduMapOptions对象
//        final BaiduMapOptions options = new BaiduMapOptions();
//        //设置需要的状态
//        //设置地图模式为卫星地图
//        options.mapType(BaiduMap.MAP_TYPE_SATELLITE);
//        //创建MapView对象
//
//        MapView mapView2 = new MapView(this, options);
//       //添加MapView对象
//        setContentView(mapView2);


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
    }
}
