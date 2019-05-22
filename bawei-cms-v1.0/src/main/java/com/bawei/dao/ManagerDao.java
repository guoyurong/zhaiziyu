package com.bawei.dao;

import com.bawei.entity.Manager;

/**
 * ����ԱDao�ӿ�
 * @author user
 *
 */
public interface ManagerDao {

	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Manager getByUserName(String userName);
	
}
