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

}
