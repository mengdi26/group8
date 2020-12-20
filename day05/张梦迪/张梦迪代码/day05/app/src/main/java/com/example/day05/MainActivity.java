package com.example.day05;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRelMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
//        mRelMain = (RecyclerView) findViewById(R.id.rel_main);
//        mRelMain.setLayoutManager(new LinearLayoutManager(this));
//        final ArrayList<String> strings = new ArrayList<>();


    }
}
