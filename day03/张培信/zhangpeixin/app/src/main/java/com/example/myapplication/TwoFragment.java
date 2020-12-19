package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TwoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager mVp;
    private TabLayout mTab;
    private ImageView mIm;
    private ImageView mIm1;
    private ImageView mIm2;
    private TextView mTv;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;

    private RecyclerView mRe;
    private ArrayList<Remenbean.DataBean> list;
    private Myadapter myadapter1;
    public TwoFragment() {
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
    public static TwoFragment newInstance(String param1, String param2) {
        TwoFragment fragment = new TwoFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);
        initData();
        return inflate;
    }
    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiServies.s)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiServies.class)
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Remenbean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Remenbean shafaBean) {
                        List<Remenbean.DataBean> data = shafaBean.getData();
                        list.addAll(data);
                        myadapter1.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    private void initView(@NonNull final View itemView) {
        mVp = (ViewPager) itemView.findViewById(R.id.vp);
        mTab = (TabLayout) itemView.findViewById(R.id.tab);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FourFragment());
        fragments.add(new FiveFragment());
        fragments.add(new SixFragment());
        fragments.add(new FourFragment());
        mVp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("热点");
        mTab.getTabAt(1).setText("妆造");
        mTab.getTabAt(2).setText("图赏");
        mTab.getTabAt(3).setText("百科");

        mIm = (ImageView) itemView.findViewById(R.id.im);
        mIm1 = (ImageView) itemView.findViewById(R.id.im1);
        mIm2 = (ImageView) itemView.findViewById(R.id.im2);
        mTv = (TextView) itemView.findViewById(R.id.tv);
        mTv1 = (TextView) itemView.findViewById(R.id.tv1);
        mTv2 = (TextView) itemView.findViewById(R.id.tv2);
        mTv3 = (TextView) itemView.findViewById(R.id.tv3);
        mTv4 = (TextView) itemView.findViewById(R.id.tv4);
        mRe = (RecyclerView) itemView.findViewById(R.id.re);
        list = new ArrayList<>();
        myadapter1 = new Myadapter(list, getActivity());
        mRe.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRe.setAdapter(myadapter1);

    }
}
