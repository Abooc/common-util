package com.abooc.common.samples;

import android.app.Application;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 15-6-29.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.init(this);
    }
}
