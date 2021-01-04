package com.example.yuandan.mvp.ui.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.example.yuandan.R;
import com.example.yuandan.adapter.SugAdapter;
import com.example.yuandan.base.BaseFragment;
import com.example.yuandan.base.BasePresenter;
import com.example.yuandan.mvp.ui.activity.SouActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class BlankFragment4 extends BaseFragment implements OnGetSuggestionResultListener {

    @BindView(R.id.city)
    EditText mEditCity;
    @BindView(R.id.searchkey)
    AutoCompleteTextView mKeyWordsView;
    @BindView(R.id.sug_list)
    RecyclerView mSugListView;
    private SuggestionSearch mSuggestionSearch;

    @Override
    protected void init() {

        //添加这下面的一部分
//动态申请权限
        List<String> permissionList = new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String[] permissions =permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(getActivity(), permissions, 1);
        }

        // 初始化建议搜索模块，注册建议搜索事件监听
        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(this);

        // 初始化view

        mKeyWordsView.setThreshold(1);

        mSugListView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 当输入关键字变化时，动态更新建议列表
        mKeyWordsView.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {

            }

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                if (cs.length() <= 0) {
                    return;
                }

                Log.e("TAG","run:1111111111111111111111111111");
                // 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
                mSuggestionSearch.requestSuggestion((new SuggestionSearchOption())
                        .keyword(cs.toString()) // 关键字
                        .city(mEditCity.getText().toString())); // 城市
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank4;
    }

    @Override
    public void getData(Object o) {

    }

    @Override
    public void onGetSuggestionResult(SuggestionResult suggestionResult) {
        if (suggestionResult == null || suggestionResult.getAllSuggestions() == null) {
            return;
        }

        ArrayList<Double> longList = new ArrayList<>();
        ArrayList<Double> latList = new ArrayList<>();
        ArrayList<String> key = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();
        ArrayList<String> dis = new ArrayList<>();
        for (SuggestionResult.SuggestionInfo info : suggestionResult.getAllSuggestions()) {
            if (info.getKey() != null && info.getDistrict() != null && info.getCity() != null) {
                key.add(info.getKey());
                city.add(info.getCity());
                dis.add(info.getDistrict());
                if (info.pt != null) {
                    Log.e("TAG", "run:" + info.pt.latitude);
                    longList.add(info.pt.longitude);
                    latList.add(info.pt.latitude);
                }
            }
        }

        SugAdapter adapter = new SugAdapter(getContext(),key,city,dis);
        mSugListView.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        adapter.setOnClick(new SugAdapter.OnClick() {
            @Override
            public void OnClickListener(int pos) {
                Intent intent = new Intent(getActivity(), SouActivity.class);
                intent.putExtra("long", longList.get(pos));
                intent.putExtra("lat", latList.get(pos));
                startActivity(intent);
            }
        });

    }
}