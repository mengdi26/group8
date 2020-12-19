package com.example.day04_zy.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day04_zy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeSonFragment extends Fragment {


    public HomeSonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home_son, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {

    }

}
