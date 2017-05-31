package com.xiaofan.buglydemo.application;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.multidex.MultiDex;
import android.view.View;
import android.widget.TextView;

import com.meituan.android.walle.WalleChannelReader;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.tinker.loader.app.DefaultApplicationLike;
import com.xiaofan.buglydemo.MainActivity;
import com.xiaofan.buglydemo.R;
import com.xiaofan.buglydemo.SecondActivity;

/**
 * Created by fanjianhai on 2017/5/21.
 */

public class SampleApplicationLike extends DefaultApplicationLike {

    public static final String TAG = "Tinker.SampleApplicationLike";

    public static final boolean DEBUG = false;

    public SampleApplicationLike(Application application, int tinkerFlags,
                                 boolean tinkerLoadVerifyFlag, long applicationStartElapsedTime,
                                 long applicationStartMillisTime, Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // 设置多渠道
        String channel = WalleChannelReader.getChannel(getApplication());
        MainActivity.channelValue = channel;

        // 显示弹窗的界面
        Beta.canShowUpgradeActs.add(SecondActivity.class);

        Beta.upgradeDialogLayoutId = R.layout.dialog_version_update;

        Beta.largeIconId = R.drawable.app_icon;
        Beta.smallIconId = R.drawable.app_icon;

        Beta.upgradeDialogLifecycleListener = new UILifecycleListener<UpgradeInfo>() {

            @Override
            public void onCreate(Context context, View view, UpgradeInfo upgradeInfo) {

            }

            @Override
            public void onStart(Context context, View view, UpgradeInfo upgradeInfo) {

            }

            @Override
            public void onResume(Context context, View view, UpgradeInfo upgradeInfo) {
                TextView tv_dialog_version_code = (TextView) view.findViewById(R.id.tv_dialog_version_code);
                tv_dialog_version_code.setText("V" + upgradeInfo.versionName);
            }

            @Override
            public void onPause(Context context, View view, UpgradeInfo upgradeInfo) {
            }

            @Override
            public void onStop(Context context, View view, UpgradeInfo upgradeInfo) {

            }

            @Override
            public void onDestroy(Context context, View view, UpgradeInfo upgradeInfo) {

            }
        };

        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(getApplication(), "3afcd9c708", DEBUG);

        CrashReport.initCrashReport(getApplication(), "3afcd9c708", DEBUG);
    }


    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        // TinkerManager.installTinker(this); 替换成下面Bugly提供的方法
        Beta.installTinker(this);
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }




    }

