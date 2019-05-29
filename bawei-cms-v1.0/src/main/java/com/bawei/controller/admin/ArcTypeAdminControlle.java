package com.bawei.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;

import com.bawei.entity.ArcType;
import com.bawei.entity.Link;
import com.bawei.entity.PageBean;
import com.bawei.service.ArcTypeService;
import com.bawei.service.ArticleService;
import com.bawei.service.LinkService;
import com.bawei.service.impl.ArcTypeServiceImpl;
import com.bawei.service.impl.InitComponet;
import com.bawei.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/arcType")
public class ArcTypeAdminControlle {
	
	@Resource
	private ArcTypeService arcTypeService;
	
	@Resource
	private InitComponet initComponet;
	
	@Resource
	private ArticleService articleService;
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,
			@RequestParam(value="rows",required=false)String rows,
			HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<ArcType> list = arcTypeService.list(map);
		JSONArray jsonArray = JSONArray.fromObject(list);
		Long total = arcTypeService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/save")
	public String save(ArcType arcType,HttpServletRequest request,HttpServletResponse response) throws Exception{
		int resultes=0;
		if (arcType.getId() != null) {
			resultes=arcTypeService.add(arcType);
		}else{
			resultes=arcTypeService.update(arcType);
		}
		JSONObject result = new JSONObject();
		if (resultes>0) {
			initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response) throws Exception{
		String[] moreid = ids.split(",");
		for (String id : moreid) {
			arcTypeService.delete(Integer.parseInt(id));
		}
		initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
