package com.fengbin.controller.admin;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.fengbin.entity.Link;
import com.fengbin.entity.PageBean;
import com.fengbin.service.LinkService;
import com.fengbin.service.impl.InitComponet;
import com.fengbin.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {

	@Resource
	private LinkService linkService;

	@Resource
	private InitComponet initComponet;

	@RequestMapping("/list")
	public String list(@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "page", required = false) String page,
			HttpServletResponse response) throws Exception {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Link> list = linkService.list(map);
		JSONArray fromObject = JSONArray.fromObject(list);
		Long toal = linkService.getToal(map);
		JSONObject jObject = new JSONObject();
		jObject.put("rows", fromObject);
		jObject.put("toal", toal);
	    ResponseUtil.write(response, jObject);
		return null;
	}

	@RequestMapping("/save")
	public String save(Link link, HttpServletRequest request, HttpServletResponse response) throws Exception {
		int res = 0;
		if (link.getId() == null) {
			res = linkService.add(link);
		} else {
			res = linkService.update(link);
		}
		JSONObject jsonObject = new JSONObject();
		if (res > 0) {
			initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		ResponseUtil.write(response, jsonObject);
		return null;

	}
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response) throws Exception {
		String[] a=ids.split(",");
		for (String id : a) {
			linkService.delete(Integer.parseInt(id));
		}
		initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}

}
