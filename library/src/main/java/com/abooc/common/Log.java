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
	 * @param cls Object
	 */
	public static void d(Object cls) {
		d(cls.toString());
	}

	/**
	 * 打印字符数组
	 * @param array 数组
	 */
	public static void d(String[] array) {
		String str = ToString.toString(array);
		d(str);
	}

}
