package com.bawei.util;

import java.util.ArrayList;
import java.util.List;

/**
 * �ַ���������
 * @author user
 *
 */
public class StringUtil {

	/**
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if(str==null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str!=null && !"".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * ���˵������еĿո�Ԫ��
	 * @param list
	 * @return
	 */
	public static List<String> filterWhite(List<String> list){
		List<String> resultList=new ArrayList<String>();
		for(String l:list){
			if(isNotEmpty(l)){
				resultList.add(l);
			}
		}
		return resultList;
	}

	/**
	 * 模糊查询条件格式化工具方法
	 * @param str
	 * @return
	 */
	public static String formatLike(String str){
		if(isNotEmpty(str)){		
			return "%"+str+"%";		
		}else{
			return null;
		}
	}
}
