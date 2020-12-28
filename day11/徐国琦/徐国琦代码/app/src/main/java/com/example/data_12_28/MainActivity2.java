package com.example.data_12_28;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView rv;
    private HomeAdater homeAdater;
    private List<Integer> list;
    private RecyclerView rvy;
    private List<Integer> lista;
    private CallAdater callAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        list.add(R.drawable.rv);
        list.add(R.drawable.rv);
        list.add(R.drawable.rv);
        list.add(R.drawable.rv);
        list.add(R.drawable.rv);
        lista.add(R.drawable.aaa);
        lista.add(R.drawable.aaa);
        lista.add(R.drawable.aaa);
        lista.add(R.drawable.aaa);
        lista.add(R.drawable.aaa);
        homeAdater.notifyDataSetChanged();
    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        rvy = findViewById(R.id.ryv);
        list = new ArrayList<>();
        lista = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        rvy.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        homeAdater = new HomeAdater(this, list);
        callAdater = new CallAdater(this, lista);
        rv.setAdapter(homeAdater);
        rvy.setAdapter(callAdater);
    }
}