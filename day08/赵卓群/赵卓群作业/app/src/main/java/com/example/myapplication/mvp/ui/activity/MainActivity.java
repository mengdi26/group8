package com.example.myapplication.mvp.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.BasePresenter;
import com.example.myapplication.manage.ContiainManager;

import butterknife.BindView;
import kotlin.jvm.JvmField;

public class MainActivity extends BaseActivity {

    @JvmField
    @BindView(R.id.Mark)
    public Button mMark;


    @JvmField
    @BindView(R.id.POI)
    public Button mPOI;

    @Override
    protected void init() {
        mMark = (Button) findViewById(R.id.Mark);
        mPOI = (Button) findViewById(R.id.POI);
        ContiainManager.getManager().addActivity(this);
        mMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "sssssss", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, MarkActivity.class);
//                startActivity(intent);
            }
        });
        mPOI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


}