package com.example.day06.mvp.view.activity;

import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.day06.R;
import com.example.day06.base.BaseActivity;
import com.example.day06.manager.ContainManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends BaseActivity {
    private boolean mIsExit;
    private Handler mHandler = new Handler();


    @Override
    protected void init() {

    }

    @Override
    protected void initData() {
        super.initData();
        Observable.just(1,2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                //用来检测网络连接

            }

            @Override
            public void onNext(Integer value) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected void click(View view) {

    }

    @Override
    protected void createPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //二秒内连续点击  退出程序，如果第二次点击超过二秒了提示再按一次退出程序
            if (!mIsExit) {
                mIsExit = true;

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                        Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    }
                }, 2000);
            } else {
                ContainManager.getmManager().clearActivity();
            }
            return false;

        }


        return super.onKeyDown(keyCode, event);
    }
}