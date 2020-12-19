package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SixFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SixFragment extends Fragment {
    private RecyclerView mHomeRv;
    private DbUtil hodler;
    private ArrayList<MyDbBean> list;
    private int post=1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Myadaptersjkk myadaptersjk;

    public SixFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SixFragment newInstance(String param1, String param2) {
        SixFragment fragment = new SixFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.five_fragment, container, false);
        initView(inflate);
        initListener();
        return inflate;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            initData();
        }else {
            if (list!=null&&list.size()>0){
                list.clear();
            }
        }
    }


    private void initListener() {
        myadaptersjk.setIoclick(new Myadaptersjkk.Ioclick() {
            @Override
            public void paa(int pos) {
                hodler.delete(list.get(pos));
                list.remove(pos);
                myadaptersjk.notifyDataSetChanged();
            }
        });




    }

    private void initData() {
        hodler = DbUtil.getDbUtil();
        List<MyDbBean> foodBdBeans = hodler.quary();
        list.addAll(foodBdBeans);
        myadaptersjk.notifyDataSetChanged();
    }

    private void initView(@NonNull final View itemView) {
        mHomeRv = (RecyclerView) itemView.findViewById(R.id.re);
        mHomeRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHomeRv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        list = new ArrayList<>();

        myadaptersjk = new Myadaptersjkk(list, getActivity());
        mHomeRv.setAdapter(myadaptersjk);
    }


}