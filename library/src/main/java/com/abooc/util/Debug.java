package com.abooc.util;

import android.util.Log;

import com.abooc.debug.BuildConfig;

import java.util.HashSet;

/**
 * Created by author:李瑞宇
 * email:ruiyulee.mail@gmail.com
 * on 15-11-30.
 */
public class Debug extends Stacker {


    public static final String TAG = "Debug";
    private static HashSet<String> mClassSet = new HashSet<>();

    public static boolean isSimpleName = true;

    /** */
    public static boolean DEBUG = BuildConfig.DEBUG;

    public static void enable(boolean enable) {
        DEBUG = enable;
    }

    /**
     * 开启Debug
     */
    public static void on() {
        DEBUG = true;
        System.out.println(TAG + " is ON.");
    }

    /**
     * 关闭Debug
     */
    public static void off() {
        System.out.println(TAG + " is OFF.");
        DEBUG = false;
    }

    /**
     * 锚点，定位
     */
    public static void anchor() {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.d(identify(className), stackString("", stack, isSimpleName));
        }
    }

    /**
     * 锚点，定位
     */
    public static void anchor(Object o) {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.d(identify(className), stackString("", stack, isSimpleName));
        }
    }

    /**
     * Debug数据
     *
     * @param o 输出的数据
     */
    public static void d(Object o) {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.d(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    /**
     * ERROR级
     */
    public static void error() {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.e(identify(className), stackString("", stack, isSimpleName));
        }
    }

    /**
     * ERROR级
     *
     * @param o
     */
    public static void e(Object o) {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.e(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    private static String identify(String cls) {
        if (mClassSet.contains(cls)) {
            return cls;
        } else
            return TAG;
    }

    /**
     * Debug本类
     */
    public static void debug() {
        StackTraceElement[] stack = new Exception().getStackTrace();
        String className = stack[1].getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        boolean add = mClassSet.add(className);
        if (add) {
            System.out.println("Change the Debug tag to '" + className + "'.");

            System.out.println(mClassSet.toString());
        }
    }

    /**
     * 移除本类的Debug
     */
    public static void dockOut() {
        StackTraceElement[] stack = new Exception().getStackTrace();
        String className = stack[1].getClassName();
        className = className.substring(className.lastIndexOf(".") + 1);
        if (mClassSet.contains(className)) {
            boolean remove = mClassSet.remove(className);
            if (remove) {
                System.out.println("Destroy the Debug tag '" + className + "'.");
                System.out.println(mClassSet.toString());
            }
        }

    }
}
