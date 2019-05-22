package com.bawei.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.ManagerDao;
import com.bawei.entity.Manager;
import com.bawei.service.ManagerService;

/**
 * ����ԱServiceʵ����
 * @author user
 *
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{

	@Resource
	private ManagerDao managerDao;

	public Manager getByUserName(String userName) {
		return managerDao.getByUserName(userName);
	}
}
