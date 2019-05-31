package com.fengbin.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fengbin.dao.LinkDao;
import com.fengbin.entity.Link;
import com.fengbin.service.LinkService;

/**
 * 友情链接Service实现类
 * @author user
 *
 */
@Service("linkService")
public class LinkServiceImpl implements LinkService{

	@Resource
	private LinkDao linkDao;
	
	public List<Link> list(Map<String, Object> map) {
		return linkDao.list(map);
	}

	@Override
	public Long getToal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return linkDao.getToal(map);
	}

	@Override
	public int add(Link link) {
		// TODO Auto-generated method stub
		return linkDao.add(link);
	}

	@Override
	public int update(Link link) {
		// TODO Auto-generated method stub
		return linkDao.update(link);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		linkDao.delete(id);
	}

}
