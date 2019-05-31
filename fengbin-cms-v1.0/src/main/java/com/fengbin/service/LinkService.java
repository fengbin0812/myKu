package com.fengbin.service;

import java.util.List;
import java.util.Map;

import com.fengbin.entity.Link;

/**
 * 友情链接Service接口
 * @author user
 *
 */
public interface LinkService {

	/**
	 * 根据条件分页查询友情链接集合
	 * @param map
	 * @return
	 */
	public List<Link> list(Map<String,Object> map);
	
	
	public Long getToal(Map<String, Object> map);
	
	public int add(Link link);
	
	public int update(Link link);


	public void delete(int id);
}
