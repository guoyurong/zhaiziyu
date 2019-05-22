package com.bawei.util;

/**
 * ����������
 * @author user
 *
 */
public class NavUtil {

	/**
	 * ���������б���
	 * @param typeName
	 * @return
	 */
	public static String genArticleListNavigation(String typeName){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("<a href='"+PropertiesUtil.getValue("host")+"'>��ҳ</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append(typeName);
		return navCode.toString();
	}
	
	/**
	 * ����������ϸҳ����
	 * @param typeName
	 * @param typeId
	 * @param articleTitle
	 * @return
	 */
	public static String genArticleNavigation(String typeName,Integer typeId,String articleTitle){
		StringBuffer navCode=new StringBuffer();
		navCode.append("��ǰλ�ã�&nbsp;&nbsp;");
		navCode.append("<a href='"+PropertiesUtil.getValue("host")+"'>��ҳ</a>&nbsp;&nbsp;>&nbsp;&nbsp;");
		navCode.append("<a href='"+PropertiesUtil.getValue("host")+"/arcType/"+typeId+".html'>"+typeName+"</a>&nbsp;&nbsp;>&nbsp;&nbsp;"+articleTitle);
		return navCode.toString();
	}
}
