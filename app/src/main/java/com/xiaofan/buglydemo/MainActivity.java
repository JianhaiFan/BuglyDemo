package com.xiaofan.buglydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.tencent.bugly.beta.Beta;
import com.xiaofan.buglydemo.util.ManifestUtil;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    public static String channelValue = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"version：" + ManifestUtil.getVersionCode(this) + "渠道信息：" + channelValue ,Toast.LENGTH_LONG).show();
    }

    public void click(View v) {

        String str = "Fan";
//        String str = null;
        String strTest = "fan";
        if (str.equalsIgnoreCase(strTest)) {
            Toast.makeText(MainActivity.this,"我是版本更新过来的...",Toast.LENGTH_LONG).show();
            Log.e(TAG,"hehe.......");
        }
    }

    public void click1(View v) {
        Toast.makeText(this,"click1...." ,Toast.LENGTH_LONG).show();
        Beta.checkUpgrade();
    }
}
