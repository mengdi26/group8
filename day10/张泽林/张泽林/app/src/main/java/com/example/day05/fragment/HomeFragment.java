package com.example.day05.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day05.R;
import com.example.day05.adpter.Adpter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rv_main;
    private Adpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv_main=view.findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.c);
        list.add(R.drawable.d);
        list.add(R.drawable.e);
        list.add(R.drawable.f);
        list.add(R.drawable.m);
        adpter = new Adpter(getContext(), list);
        rv_main.setAdapter(adpter);
    }
}