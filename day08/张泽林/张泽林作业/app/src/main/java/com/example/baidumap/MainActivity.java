package com.example.baidumap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MapView mapView;
    private BaiduMap mMBaiduMap;
    private RadioButton mRbStar;
    private RadioButton mRbStyle;
    private RadioGroup mRg;
    private LocationClient mMLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(R.id.mapView);
        int i = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        //申请动态权限
        if(i== PackageManager.PERMISSION_GRANTED){
            initView();
        }else{
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }
    }

    private void initView() {
        mMBaiduMap = mapView.getMap();
        //TODO 开启地图的定位图层
        mMBaiduMap.setMyLocationEnabled(true);
        //定位初始化
        mMLocationClient = new LocationClient(this);
        //通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
//设置locationClientOption
        mMLocationClient.setLocOption(option);
//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mMLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mMLocationClient.start();
        mRbStar = (RadioButton) findViewById(R.id.weixing);
        mRbStar.setOnClickListener(this);
        mRbStyle = (RadioButton) findViewById(R.id.putong);
        mRbStyle.setOnClickListener(this);
        mRg = (RadioGroup) findViewById(R.id.rg_main);
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {

            //mapView 销毁后不在处理新接收的位置
            if (location == null || mapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mMBaiduMap.setMyLocationData(locData);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mapView:
                break;
            case R.id.weixing:
                //卫星地图
                mMBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);

                break;
            case R.id.putong:
                //普通地图 ,mBaiduMap是地图控制器对象
                mMBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMLocationClient.stop();
        mMBaiduMap.setMyLocationEnabled(false);
        mapView.onDestroy();
        mapView = null;

    }

    @Override
    //重写方法接受动态授权的结果
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //授权
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
            initView();
        } else {
            Toast.makeText(this, "未授权", Toast.LENGTH_SHORT).show();
        }

    }
}