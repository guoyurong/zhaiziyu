package com.bawei.entity;

/**
 * �������ʵ��
 * @author user
 *
 */
public class ArcType {

	private Integer id; // ���
	private String typeName; // �������
	private Integer sortNo; // �������
	private String keywords; // �ؼ��� ҳ��seo�õ�
	private String description; // ������� ҳ��seo�õ�
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
