package cn.jiguang.demo.jshare;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;


import androidx.core.app.ActivityCompat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import cn.jiguang.demo.R;
import cn.jiguang.demo.jshare.uitool.ShareBoard;
import cn.jiguang.demo.jshare.uitool.ShareBoardlistener;
import cn.jiguang.demo.jshare.uitool.SnsPlatform;
import cn.jiguang.share.android.api.JShareInterface;
import cn.jiguang.share.android.api.PlatActionListener;
import cn.jiguang.share.android.api.Platform;
import cn.jiguang.share.android.api.ShareParams;
import cn.jiguang.share.android.utils.Logger;
import cn.jiguang.share.facebook.Facebook;
import cn.jiguang.share.facebook.messenger.FbMessenger;
import cn.jiguang.share.jchatpro.JChatPro;
import cn.jiguang.share.qqmodel.QQ;
import cn.jiguang.share.qqmodel.QZone;
import cn.jiguang.share.twitter.Twitter;
import cn.jiguang.share.wechat.Wechat;
import cn.jiguang.share.wechat.WechatFavorite;
import cn.jiguang.share.wechat.WechatMoments;
import cn.jiguang.share.weibo.SinaWeibo;
import cn.jiguang.share.weibo.SinaWeiboMessage;


public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private int mAction = Platform.ACTION_SHARE;
    private ProgressDialog progressDialog;
    private ShareBoard mShareBoard;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String toastMsg = (String) msg.obj;
            Toast.makeText(MainActivity.this, toastMsg, Toast.LENGTH_SHORT).show();
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jshare_activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("请稍候");
        findViewById(R.id.btn_share).setOnClickListener(this);
        findViewById(R.id.btn_share_pop).setOnClickListener(this);

        findViewById(R.id.btn_getuser).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, SelectPlatActivity.class);
        switch (view.getId()) {
            case R.id.btn_share:
                intent.putExtra("type", Platform.ACTION_SHARE);//分享
                startActivity(intent);
                break;
            case R.id.btn_login:
                intent.putExtra("type", Platform.ACTION_AUTHORIZING);//授权
                startActivity(intent);
                break;
            case R.id.btn_getuser:
                intent.putExtra("type", Platform.ACTION_USER_INFO);//获取个人信息
                startActivity(intent);
                break;
            case R.id.btn_share_pop:
                mAction = Platform.ACTION_SHARE;
                showBroadView();
                break;
        }

    }

    private void showBroadView() {
        if (mShareBoard == null) {
            mShareBoard = new ShareBoard(this);
            List<String> platforms = JShareInterface.getPlatformList();
            if (platforms != null) {
                Iterator var2 = platforms.iterator();
                while (var2.hasNext()) {
                    String temp = (String) var2.next();
                    SnsPlatform snsPlatform = createSnsPlatform(temp);
                    mShareBoard.addPlatform(snsPlatform);
                }
            }
            mShareBoard.setShareboardclickCallback(mShareBoardlistener);
        }
        mShareBoard.show();
    }

    private ShareBoardlistener mShareBoardlistener = new ShareBoardlistener() {
        @Override
        public void onclick(SnsPlatform snsPlatform, String platform) {

            switch (mAction) {
                case Platform.ACTION_SHARE:
                    progressDialog.show();
                    //这里以分享链接为例

                    int shareType = Platform.SHARE_WEBPAGE;
                    if (JChatPro.Name.equals(platform)) {
                        shareType = Platform.SHARE_TEXT;
                    }
                    ShareParams shareParams = new ShareParams();
                    shareParams.setShareType(shareType);
                    shareParams.setTitle(ShareTypeActivity.share_title);
                    shareParams.setText(ShareTypeActivity.share_text);
                    shareParams.setUrl(ShareTypeActivity.share_url);
                    shareParams.setImagePath(FileTestCopy.ImagePath);
                    JShareInterface.share(platform, shareParams, mShareListener);
                    break;
                default:
                    break;
            }
        }
    };

    private PlatActionListener mShareListener = new PlatActionListener() {
        @Override
        public void onComplete(Platform platform, int action, HashMap<String, Object> data) {
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享成功";
                handler.sendMessage(message);
            }
        }

        @Override
        public void onError(Platform platform, int action, int errorCode, Throwable error) {
            Logger.e(TAG, "error:" + errorCode + ",msg:" + error);
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享失败:" + error.getMessage();
                handler.sendMessage(message);
            }
        }

        @Override
        public void onCancel(Platform platform, int action) {
            if (handler != null) {
                Message message = handler.obtainMessage();
                message.obj = "分享取消";
                handler.sendMessage(message);
            }
        }
    };


    public static SnsPlatform createSnsPlatform(String platformName) {
        String mShowWord = platformName;
        String mIcon = "";
        String mGrayIcon = "";
        String mKeyword = platformName;
        if (platformName.equals(Wechat.Name)) {
            mIcon = "jshare_jiguang_socialize_wechat";
            mGrayIcon = "jshare_jiguang_socialize_wechat";
            mShowWord = "jshare_jiguang_socialize_text_weixin_key";
        } else if (platformName.equals(WechatMoments.Name)) {
            mIcon = "jshare_jiguang_socialize_wxcircle";
            mGrayIcon = "jshare_jiguang_socialize_wxcircle";
            mShowWord = "jshare_jiguang_socialize_text_weixin_circle_key";

        } else if (platformName.equals(WechatFavorite.Name)) {
            mIcon = "jshare_jiguang_socialize_wxfavorite";
            mGrayIcon = "jshare_jiguang_socialize_wxfavorite";
            mShowWord = "jshare_jiguang_socialize_text_weixin_favorite_key";

        } else if (platformName.equals(SinaWeibo.Name)) {
            mIcon = "jshare_jiguang_socialize_sina";
            mGrayIcon = "jshare_jiguang_socialize_sina";
            mShowWord = "jshare_jiguang_socialize_text_sina_key";
        } else if (platformName.equals(SinaWeiboMessage.Name)) {
            mIcon = "jshare_jiguang_socialize_sina";
            mGrayIcon = "jshare_jiguang_socialize_sina";
            mShowWord = "jshare_jiguang_socialize_text_sina_msg_key";
        } else if (platformName.equals(QQ.Name)) {
            mIcon = "jshare_jiguang_socialize_qq";
            mGrayIcon = "jshare_jiguang_socialize_qq";
            mShowWord = "jshare_jiguang_socialize_text_qq_key";

        } else if (platformName.equals(QZone.Name)) {
            mIcon = "jshare_jiguang_socialize_qzone";
            mGrayIcon = "jshare_jiguang_socialize_qzone";
            mShowWord = "jshare_jiguang_socialize_text_qq_zone_key";
        } else if (platformName.equals(Facebook.Name)) {
            mIcon = "jshare_jiguang_socialize_facebook";
            mGrayIcon = "jshare_jiguang_socialize_facebook";
            mShowWord = "jshare_jiguang_socialize_text_facebook_key";
        } else if (platformName.equals(FbMessenger.Name)) {
            mIcon = "jshare_jiguang_socialize_messenger";
            mGrayIcon = "jshare_jiguang_socialize_messenger";
            mShowWord = "jshare_jiguang_socialize_text_messenger_key";
        } else if (Twitter.Name.equals(platformName)) {
            mIcon = "jshare_jiguang_socialize_twitter";
            mGrayIcon = "jshare_jiguang_socialize_twitter";
            mShowWord = "jshare_jiguang_socialize_text_twitter_key";
        } else if (platformName.equals(JChatPro.Name)) {
            mShowWord = "jshare_jiguang_socialize_text_jchatpro_key";
        }
        return ShareBoard.createSnsPlatform(mShowWord, mKeyword, mIcon, mGrayIcon, 0);
    }

}
