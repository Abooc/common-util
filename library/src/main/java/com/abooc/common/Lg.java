package com.abooc.common;

import org.lee.java.util.Empty;
import org.lee.java.util.Type;

/**
 * 锚点类
 *
 * @author ruiyuLee
 */
class Lg {

    public static final String TAG = "TAG";
    private static final int LOG_ID_EVENTS = 2;

    /** */
    public static boolean DEBUG = true;
    /** 是否输出完整的package名 */
    public static final boolean hasPackageName = false;

    public static String mMessageHeader = ":\n";
    public static String mMessageFooter = "";

    /**
     * 设置Debug模式
     * @param enable 是否开启Debug模式，true则打印log，false则关闭log打印。
     */
    public static void setDebugEnable(boolean enable) {
        DEBUG = enable;
    }

    public static void anchor() {
        anchor("");
    }

    private static boolean isDebug(){
        return DEBUG;
    }
    /**
     * 基方法
     *
     * @param cls class Or Object
     */
    public static void anchor(Object cls) {
        if (!isDebug()) return;

        StackTraceElement[] stack = new Exception().getStackTrace();
        String me = stack[0].getMethodName();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int size = stack.length;
        for (; i < size; i++) {
            if (!me.equals(stack[i].getMethodName())) {
                if (Type.canToString(cls)) {
                    stringBuffer.append(stack[i]
                            + (Empty.isEmpty(String.valueOf(cls)) ? " "
                            : mMessageHeader + String.valueOf(cls)));
                } else {
                    stringBuffer.append(stack[i] + mMessageHeader + cls);
                }
                break;
            }
        }

        if (!hasPackageName) {
            String fullClassName = stack[i].toString();
            fullClassName = fullClassName.substring(0,
                    fullClassName.lastIndexOf("."));
            fullClassName = fullClassName.substring(0,
                    fullClassName.lastIndexOf("."));
            String packageName = fullClassName.substring(0,
                    fullClassName.lastIndexOf("."));
            stringBuffer.delete(0, packageName.length() + 1);
        }
        d(stringBuffer.toString() + mMessageFooter);
    }

    public static String toStackTraceString(Object cls) {
        StackTraceElement[] stack = new Exception().getStackTrace();
        return stack[2].toString() + mMessageHeader + cls.toString()
                + mMessageFooter;
    }

    public static void e(Object cls) {
        if (!isDebug()) return;

        String str = toStackTraceString(cls);
        android.util.Log.e(TAG, str);
    }

    /**
     * 打印指定字符串
     * @param msg 要输出的内容
     */
    public static void d(String msg) {
        if (!isDebug()) return;


        android.util.Log.println(LOG_ID_EVENTS, TAG, msg);
    }

}
