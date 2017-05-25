package com.xiaofan.buglydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.xiaofan.buglydemo.util.ManifestUtil;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this,"version：" + ManifestUtil.getVersionCode(this),Toast.LENGTH_LONG).show();
    }

    public void click(View v) {

        String str = "Fan";
//        String str = null;
        String strTest = "fan";
        if (str.equalsIgnoreCase(strTest)) {
            Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
            Log.e(TAG,"hehe.......");
        }
    }
}
