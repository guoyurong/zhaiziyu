package com.zhaiziyu.util;

import java.util.HashSet;

public class RandomUtil {

	public static Long getRandomUtil(long start,long end){
		//随机数是0-1之间  *（end-start） 为 0-（end-start） 之间
		long result=((long)(Math.random()*(end-start))+start);
		//判断
		if ((result == start)||(result == end)) {
			return RandomUtil.getRandomUtil(start, end);
		}
		//返回值
		return result;
	}
	
	public static String getRandomSet(long start,long end,int n){
		HashSet<Long> hashSet = new HashSet<Long>();
		String string="0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		char[] charArray = string.toCharArray();
		int length = charArray.length;
		while(hashSet.size()<n){
			
		}
		return string;
	}
}
