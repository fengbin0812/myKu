package com.fengbin.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengbin.entity.Manager;
import com.fengbin.service.ManagerService;
import com.fengbin.util.Md5Util;
import com.fengbin.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/manager")
public class ManagerAdminController {

	@Resource
	private ManagerService mService;
	
	@RequestMapping("/modifyPassword")
	public String update(String newPassword,HttpServletResponse response) throws Exception {
		Manager manager = new Manager();
		manager.setPassword(Md5Util.md5(newPassword, Md5Util.SALT));
		int update = mService.update(manager);
		JSONObject jsonObject = new JSONObject();
		if(update>0) {
			jsonObject.put("success", true);
		}else {
			jsonObject.put("success", false);
		}
		ResponseUtil.write( response, jsonObject);
		return null;
	}
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "redirect:/admin/login.jsp";
	}
}
