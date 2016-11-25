package com.abooc.util;

import android.util.Log;

import com.abooc.debug.BuildConfig;

import java.util.HashSet;

import static android.util.Log.ASSERT;
import static android.util.Log.DEBUG;
import static android.util.Log.ERROR;
import static android.util.Log.INFO;
import static android.util.Log.VERBOSE;
import static android.util.Log.WARN;

/**
 * Created by author:李瑞宇
 * email:ruiyulee.mail@gmail.com
 * on 15-11-30.
 */
public class Debug extends Stacker {


    public static final String DEFAULT_TAG = Debug.class.getSimpleName();
    public static String TAG = DEFAULT_TAG;

    /**
     * 日志开关
     */
    public static boolean DEBUG_ENABLE = BuildConfig.DEBUG;
    public static final int DEFAULT_LEVEL = Log.DEBUG;
    /**
     * 日志级别
     */
    public static int LEVEL = DEFAULT_LEVEL;

    private static HashSet<String> mClassSet = new HashSet<>();

    public static boolean isSimpleName = true;

    /**
     * 开启Debug日志
     *
     * @param enable true开启，false关闭
     */
    public static void enable(boolean enable) {
        DEBUG_ENABLE = enable;
    }

    /**
     * Debug日志是否开启
     *
     * @return true开启状态，false关闭状态
     */
    public static boolean enable() {
        return DEBUG_ENABLE;
    }

    /**
     * 参见：{@link android.util.Log}
     * <p>
     * public static final int ASSERT = 7;
     * public static final int DEBUG_ENABLE = 3;
     * public static final int ERROR = 6;
     * public static final int INFO = 4;
     * public static final int VERBOSE = 2;
     * public static final int WARN = 5;
     *
     * @param level DEBUG_ENABLE、ERROR、INFO ...
     */
    public static void setLevel(int level) {
        LEVEL = level;
    }


    /**
     * @param tag 设置TAG
     */
    public static void setTag(String tag) {
        TAG = tag;
    }

    /**
     * 开启Debug日志
     */
    public static void debugOn() {
        DEBUG_ENABLE = true;
        System.out.println(DEFAULT_TAG + " is ON.");
    }

    /**
     * 关闭Debug日志
     */
    public static void debugOff() {
        DEBUG_ENABLE = false;
        System.out.println(DEFAULT_TAG + " is OFF.");
    }

    /**
     * @param TAG     TAG
     * @param message 输出的数据
     */
    private static void output(String TAG, String message) {
        switch (LEVEL) {
            case VERBOSE:
                Log.v(TAG, message);
                break;
            case DEBUG:
                Log.d(TAG, message);
                break;
            case INFO:
                Log.i(TAG, message);
                break;
            case WARN:
                Log.w(TAG, message);
                break;
            case ERROR:
                Log.e(TAG, message);
                break;
            case ASSERT:
            default:
                Log.d(TAG, message);
                break;
        }
    }

    /**
     * 锚点，定位
     */
    public static void anchor() {
        if (DEBUG_ENABLE) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            output(identify(className), stackString("", stack, isSimpleName));
        }
    }

    /**
     * 锚点，定位
     *
     * @param o 输出的数据
     */
    public static void anchor(Object o) {
        if (DEBUG_ENABLE) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            output(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    /**
     * Debug数据
     *
     * @param o 输出的数据
     */
    public static void d(Object o) {
        if (DEBUG_ENABLE) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            output(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    /**
     * ERROR级
     */
    public static void error() {
        if (DEBUG_ENABLE) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.e(identify(className), stackString("", stack, isSimpleName));
        }
    }

    /**
     * ERROR级
     *
     * @param o 输出的数据
     */
    public static void error(Object o) {
        if (DEBUG_ENABLE) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.e(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    /**
     * @param cls class
     * @return String
     */
    private static String identify(String cls) {
        if (mClassSet.contains(cls)) {
            return cls;
        } else
            return TAG;
    }

    /**
     * Debug本类，已本类的类名为TAG输出日志
     */
    public static void debugClass() {
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
     * 移除本类的Debug的TAG标记
     */
    public static void destroyClass() {
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
