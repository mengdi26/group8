package com.example.data_12_21.mvp.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.example.data_12_21.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class WalkRotateLineActivity extends AppCompatActivity {
    @BindView(R.id.st_city)
    EditText stCity;
    @BindView(R.id.st_node)
    AutoCompleteTextView stNode;
    @BindView(R.id.input_search)
    LinearLayout inputSearch;
    @BindView(R.id.ed_city)
    EditText edCity;
    @BindView(R.id.ed_node)
    AutoCompleteTextView edNode;
    @BindView(R.id.drive)
    Button drive;
    @BindView(R.id.map)
    MapView mMapView;
    @BindView(R.id.customicon)
    Button customicon;
    @BindView(R.id.pre)
    Button pre;
    @BindView(R.id.btn_search)
    Button mBtnSearch;
    private Unbinder mBind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
        mBind = ButterKnife.bind(this);
        initPermission();
    }

    private void initPermission(){
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        });
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
        mMapView.onDestroy();
        super.onDestroy();
    }
}
