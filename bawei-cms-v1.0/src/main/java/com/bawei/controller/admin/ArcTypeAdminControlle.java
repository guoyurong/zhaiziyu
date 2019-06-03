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
import com.bawei.entity.Article;
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
	public String list(@RequestParam(value="page")String page,
			@RequestParam(value="rows")String rows,
			HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<Article> list = articleService.list(map);
		JSONArray jsonArray = JSONArray.fromObject(list);
		Long total = articleService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
