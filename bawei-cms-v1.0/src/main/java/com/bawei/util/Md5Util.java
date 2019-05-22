package com.bawei.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Md5���ܹ�����
 * @author user
 *
 */
public class Md5Util {

	public static final String SALT="root";
	
	/**
	 * Md5����
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str, salt).toString();
	}
	
	public static void main(String[] args) {
		String password="123456";
		System.out.println("Md5加密结果："+Md5Util.md5(password, Md5Util.SALT));
	}
}
