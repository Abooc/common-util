package com.abooc.widget;

import android.content.Context;

/**
 * 简单包装Toast，继承自android.widget.Toast. <br>
 * 1.单例化。 <br>
 * 2.调用的方法更简单。 <br>
 * 3.内容即时显示。在前一次执行show且尚未消失时，这时show新内容时，可以即时显示新内容。
 *
 * Created by author:李瑞宇
 * email:ruiyulee.mail@gmail.com
 *
 */
public class Toast extends android.widget.Toast {

    private static final String MESSAGE_NULL_POINTER_EXCEPTION = "Toast.mContext == null, 请先调用init(Context context)方法进行初始化！";
    private static android.widget.Toast mInstance;
    private static Context mContext = null;

    private Toast(Context context) {
        super(context);
    }

    private static android.widget.Toast newInstance(Context context) {
        mContext = context.getApplicationContext();
        return android.widget.Toast.makeText(mContext, null, Toast.LENGTH_SHORT);
    }

    /**
     * 该方法很重要，提前做初始化，方便之后调用方法时可以不传递Context.
     *
     * @param context Context
     */
    public static void init(Context context) {
        if (context == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        mInstance = newInstance(context);
    }

    public static void show(int textId) {
        if (mContext == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        show(textId, Toast.LENGTH_SHORT);
    }

    public static void show(String text) {
        if (mContext == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        show(text, Toast.LENGTH_SHORT);
    }

    /**
     * @param text 文本内容
     */
    public static void showInLongTime(String text) {
        if (mContext == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        show(text, Toast.LENGTH_LONG);
    }

    /**
     * @param textId   The new text for the Toast.
     * @param duration Set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     */
    public static void show(int textId, int duration) {
        if (mContext == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        if (mInstance == null) {
            mInstance = newInstance(mContext);
        }
        mInstance.setText(textId);
        mInstance.setDuration(duration);
        mInstance.show();
    }

    /**
     * @param text     The new text for the Toast.
     * @param duration Set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     */
    public static void show(String text, int duration) {
        if (mContext == null)
            throw new NullPointerException(MESSAGE_NULL_POINTER_EXCEPTION);
        if (mInstance == null) {
            mInstance = newInstance(mContext);
        }
        mInstance.setText(text);
        mInstance.setDuration(duration);
        mInstance.show();
    }
}
