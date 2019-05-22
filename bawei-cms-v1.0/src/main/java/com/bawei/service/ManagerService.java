package com.bawei.service;

import com.bawei.entity.Manager;

/**
 * ����ԱService�ӿ�
 * @author user
 *
 */
public interface ManagerService {

	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Manager getByUserName(String userName);
}
