package com.abooc.debug.samples;

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
        // 设置Debug是否可用
        Debug.enable(BuildConfig.DEBUG);
        super.onCreate();

        // 锚点
        Debug.anchor();

        // debug本类，将会以本类名作为日志TAG(标签)
        Debug.debugClass();
        // 此时锚点打印，将会以本类名作为日志TAG(标签)
        Debug.anchor();
        // 停止将本类名作为日志TAG
        Debug.destroyClass();
    }
}
