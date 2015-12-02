package com.abooc.util;

import android.util.Log;

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
    public static boolean DEBUG = true;

    /**
     * 开启Debug
     */
    public static void on() {
        DEBUG = true;
        System.out.println("Debug is ON.");
    }

    /**
     * 关闭Debug
     */
    public static void off() {
        System.out.println("Debug is OFF.");
        DEBUG = false;
    }

    public static void anchor() {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.d(identify(className), stackString("", stack, isSimpleName));
        }
    }

    public static void d(Object o) {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.d(identify(className), stackString(o, stack, isSimpleName));
        }
    }

    public static void error() {
        if (DEBUG) {
            StackTraceElement[] stack = new Exception().getStackTrace();
            String className = stack[1].getClassName();
            className = className.substring(className.lastIndexOf(".") + 1);
            Log.e(identify(className), stackString("", stack, isSimpleName));
        }
    }

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

    public static void destroy() {
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
