package com.example.day03_exam.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_exam.App;
import com.example.day03_exam.R;
import com.example.day03_exam.Student;
import com.example.day03_exam.adpter.RvAdpter;

import java.util.ArrayList;
import java.util.List;


public class MyFragment extends Fragment {

    private RecyclerView rv_main;
    private ArrayList<Student> students;
    private RvAdpter adpter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        initView(view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            initData();
        }else {
            if(students!=null&&students.size()>0){
                students.clear();
            }
        }
    }

    private void initData() {
        List<Student> students = App.daoSession.getStudentDao().loadAll();
        students.addAll(students);
        adpter.notifyDataSetChanged();
    }

    private void initView(View view) {
        rv_main=view.findViewById(R.id.rv_main);
        rv_main.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_main.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        students = new ArrayList<>();
        adpter = new RvAdpter(getActivity(), students);
        rv_main.setAdapter(adpter);
    }
}