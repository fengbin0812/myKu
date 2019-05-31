package com.fengbin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fengbin.dao.ArcTypeDao;
import com.fengbin.entity.ArcType;
import com.fengbin.service.ArcTypeService;

/**
 * 帖子类别Service实现类
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
	public Long getToal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return arcTypeDao.getToal(map);
	}

	@Override
	public int save(ArcType aType) {
		// TODO Auto-generated method stub
		return arcTypeDao.save(aType);
	}

	@Override
	public int update(ArcType aType) {
		// TODO Auto-generated method stub
		return arcTypeDao.update(aType);
	}

}
