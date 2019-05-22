package com.bawei.dao;

import java.util.List;
import java.util.Map;

import com.bawei.entity.ArcType;

/**
 * �������Dao�ӿ�
 * @author user
 *
 */
public interface ArcTypeDao {

	/**
	 * ����������ҳ��ѯ������𼯺�
	 * @param map
	 * @return
	 */
	public List<ArcType> list(Map<String,Object> map);
	
	/**
	 * ����id��ѯʵ��
	 * @param id
	 * @return
	 */
	public ArcType findById(Integer id);
}
