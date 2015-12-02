package com.abooc.util;

/**
 * Created by author:李瑞宇
 * email:ruiyulee.mail@gmail.com
 * on 15-11-30.
 */
public class Stacker {

    public static String mMessageHeader = ":\n";
    public static String mMessageFooter = "";

    /**
     * @param cls class Or Object
     *
     * @hide
     */
    protected static String stackString(Object cls, StackTraceElement[] stack, boolean isSimpleName) {
        String me = stack[0].getMethodName();
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int size = stack.length;
        for (; i < size; i++) {
            if (!me.equals(stack[i].getMethodName())) {
                stringBuffer.append(stack[i].toString() + mMessageHeader   //第一行 + ':'
                        + cls);                                 //打印内容
                break;
            }
        }

        if(isSimpleName){
            String className = stack[i].getClassName();
            stringBuffer.delete(0, className.lastIndexOf(".") + 1);
        }
        return stringBuffer.toString() + mMessageFooter;
    }

    /** @hide */
    private static String toStackTraceString(Object cls) {
        StackTraceElement[] stack = new Exception().getStackTrace();
        return stack[1].toString() + ", " + cls.toString()
                + mMessageFooter;
    }
}
