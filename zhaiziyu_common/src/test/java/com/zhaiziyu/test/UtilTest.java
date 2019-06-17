package com.zhaiziyu.test;


import org.junit.Test;

import com.zhaiziyu.util.RandomUtil;

public class UtilTest {
	
	@Test
	public void getgetRandomUtilTest(){
		Long randomUtil = RandomUtil.getRandomUtil(10, 100);
		System.out.println(randomUtil);
	}

}
