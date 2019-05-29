package com.bawei.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bawei.dao.ArcTypeDao;
import com.bawei.entity.ArcType;
import com.bawei.service.ArcTypeService;

/**
 * �������Serviceʵ����
 * @author user
 *
 */
@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService{

	@Resource
	private ArcTypeDao arcTypeDao;
	
	public List<ArcType> list(Map<String, Object> map) {
		return arcTypeDao.list(map);
	}

	public ArcType findById(Integer id) {
		return arcTypeDao.findById(id);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		return arcTypeDao.getTotal(map);
	}

	@Override
	public Integer add(ArcType arcType) {
		return arcTypeDao.add(arcType);
	}

	@Override
	public Integer update(ArcType arcType) {
		return arcTypeDao.update(arcType);
	}

	@Override
	public Integer delete(Integer id) {
		return arcTypeDao.delete(id);
	}

}
