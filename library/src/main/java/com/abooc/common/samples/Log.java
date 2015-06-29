package com.abooc.common.samples;

import org.lee.java.util.ToString;

/**
 * 自定义Log
 * 
 * @author ruiyuLee
 * 
 */
public class Log extends Lg {

	public static void d(Object cls) {
		println(cls.toString());
	}

	public static void d(String[] a) {
		String str = ToString.toString(a);
		println(str);
	}

}
