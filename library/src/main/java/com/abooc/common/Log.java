package com.abooc.common;

import org.lee.java.util.ToString;

/**
 * 自定义Log
 * 
 * @author ruiyuLee
 * 
 */
public class Log extends Lg {

	/**
	 * 打印对象
	 * @param cls
	 */
	public static void d(Object cls) {
		d(cls.toString());
	}

	/**
	 * 打印字符数组
	 * @param a
	 */
	public static void d(String[] a) {
		String str = ToString.toString(a);
		d(str);
	}

}
