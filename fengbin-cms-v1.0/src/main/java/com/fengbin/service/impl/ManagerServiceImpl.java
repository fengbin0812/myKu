package com.fengbin.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fengbin.dao.ManagerDao;
import com.fengbin.entity.Manager;
import com.fengbin.service.ManagerService;

/**
 * 管理员Service实现类
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
