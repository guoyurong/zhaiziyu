package com.bawei.dao;

import java.util.List;
import java.util.Map;

import com.bawei.entity.Link;

/**
 * ��������Dao�ӿ�
 * @author user
 *
 */
public interface LinkDao {

	/**
	 * 根据条件分页查询友情链接集合
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);
	/**
	 * 获取友情链表的总数量
	 * @param map
	 * @return
	 */
	public Long getToal(Map<String, Object> map);
	/**
	 * 友情链接添加功能
	 * @param link
	 * @return
	 */
	public Integer add(Link link);
	/**
	 * 友情链接修改功能
	 * @param id
	 * @return
	 */
	public Integer update(Link link);
	
	/**
	 * 友情链接删除功能
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
