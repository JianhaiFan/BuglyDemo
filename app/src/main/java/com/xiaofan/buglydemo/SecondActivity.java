package com.xiaofan.buglydemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.tencent.bugly.beta.Beta;

/**
 * Created by fanjianhai on 2017/5/31.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void click(View view) {
        Toast.makeText(this, "SecondActivity...", Toast.LENGTH_SHORT).show();
        Beta.checkUpgrade();
    }
}
