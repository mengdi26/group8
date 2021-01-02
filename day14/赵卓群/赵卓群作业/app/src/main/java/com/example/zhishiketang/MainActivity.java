package com.example.zhishiketang;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView rv_main;
    private ArrayList<Integer> list;
    private Adpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        toolbar.setTitle("基金从业");
        toolbar.setTitleMargin(270,0,0,0);
        toolbar.setLogo(R.drawable.icon_home_pager_selected);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        list.add(R.drawable.t1);
        list.add(R.drawable.t2);
        list.add(R.drawable.t3);
        list.add(R.drawable.t4);
        adpter = new Adpter(this, list);
        rv_main.setAdapter(adpter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu,menu);
        menu.add(0,0,0,"sss");
        return true;
    }
}