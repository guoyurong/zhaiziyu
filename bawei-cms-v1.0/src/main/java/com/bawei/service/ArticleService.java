package com.bawei.service;

import java.util.List;
import java.util.Map;

import com.bawei.entity.Article;

/**
 * ����Service�ӿ�
 * @author user
 *
 */
public interface ArticleService {

	/**
	 * ��ȡ���µ�7������
	 * @return
	 */
	public List<Article> getNewest();
	
	/**
	 * ��ȡ����7���Ƽ�������
	 * @return
	 */
	public List<Article> getRecommend();
	
	/**
	 * ��ȡ����5���õƵ�����
	 * @return
	 */
	public List<Article> getSlide();
	
	/**
	 * ��������������������µ�8������
	 * @param typeId
	 * @return
	 */
	public List<Article> getIndex(Integer typeId);
	
	/**
	 * ͨ��id��ѯ����
	 * @param id
	 * @return
	 */
	public Article findById(Integer id);
	
	/**
	 * ��ȡ��һ������
	 * @param id
	 * @return
	 */
	public Article getLastArticle(Integer id);
	
	/**
	 * ��ȡ��һ������
	 * @param id
	 * @return
	 */
	public Article getNextArticle(Integer id);
	
	/**
	 * ��������
	 * @param article
	 * @return
	 */
	public Integer update(Article article);
	
	/**
	 * ����������ҳ��ѯ����
	 * @param map
	 * @return
	 */
	public List<Article> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
}
