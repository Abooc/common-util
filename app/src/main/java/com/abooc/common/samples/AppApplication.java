package com.abooc.common.samples;

import android.app.Application;

import com.abooc.util.Debug;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 15-6-29.
 */
public class AppApplication extends Application {

    @Override
    public void onCreate() {
        Debug.enable(BuildConfig.DEBUG);
        super.onCreate();

        Debug.anchor();

        Debug.debugClass();
        Debug.anchor();

    }
}
