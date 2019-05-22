package com.bawei.util;

/**
 * ��ҳ������
 * @author user
 *
 */
public class PageUtil {

	/**
	 * ��������ҳ����
	 * @param totalNum
	 * @param currentPage
	 * @param pageSize
	 * @param typeId
	 * @return
	 */
	public static String genUpAndDownPagation(int totalNum,int currentPage,int pageSize,String typeId){
		int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
		StringBuffer pageCode=new StringBuffer();
		if(currentPage==1){
			pageCode.append("<a>��һҳ</a>");
		}else{
			pageCode.append("<a href='"+PropertiesUtil.getValue("host")+"/arcType/"+typeId+".html?page="+(currentPage-1)+"'>��һҳ</a>");
		}
		pageCode.append("&nbsp;&nbsp;");
		if(currentPage==totalPage){
			pageCode.append("<a>��һҳ</a>");
		}else{
			pageCode.append("<a href='"+PropertiesUtil.getValue("host")+"/arcType/"+typeId+".html?page="+(currentPage+1)+"'>��һҳ</a>");
		}
		return pageCode.toString();
	}
}
