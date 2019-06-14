package com.bawei.controller.admin;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;

import com.bawei.entity.Article;
import com.bawei.entity.PageBean;
import com.bawei.service.ArticleService;
import com.bawei.service.impl.InitComponet;
import com.bawei.util.DateUtil;
import com.bawei.util.ResponseUtil;
import com.bawei.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/admin/arcType")
public class ArticleAdminControlle {
	
	
	@Resource
	private InitComponet initComponet;
	
	@Resource
	private ArticleService articleService;
	
	@RequestMapping("/save")
	public String save(@RequestParam("slideImageFile") MultipartFile slideImageFile,Article article,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(!slideImageFile.isEmpty()){
			//获取根路径
			String realPath = request.getServletContext().getRealPath("/");
			//上传图片重新命名
			String imageName = DateUtil.getCurrentDateStr()+"."+slideImageFile.getOriginalFilename().split("\\.")[1];
			//上传图片到指定位置
			slideImageFile.transferTo(new File(realPath+"static/userImages/"+imageName));
			//文章中图片的名称
			article.setSlideImage(imageName);
		}
		article.setPublishDate(new Date());
		int reaultes = 0;
		if(article.getId()==null){//添加操作
			reaultes = articleService.add(article);
		}else{//修改操作
			reaultes = articleService.update(article);
		}
		
		StringBuffer result = new StringBuffer();
		if(reaultes > 0){
			
			initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());			
			result.append("<script language='javascript'>alert('提交成功');</script>");
		}else{
			result.append("<script language='javascript'>alert('提交失败');</script>");
		}
		
		ResponseUtil.write(response, result);
		return null;
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam(value="page",required=false)String page,
			@RequestParam(value="rows",required=false)String rows,Article article,
			HttpServletResponse response) throws Exception{
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", StringUtil.formatLike(article.getTitle()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Article> list = articleService.list(map);
		JSONArray jsonArray = JSONArray.fromObject(list);
		Long total = articleService.getTotal(map);
		JSONObject result = new JSONObject();
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(value="ids")String ids,HttpServletResponse response) throws Exception{
		String[] moreid = ids.split(",");
		for (String id : moreid) {
			articleService.delete(Integer.parseInt(id));
		}
		initComponet.refreshSystem(ContextLoader.getCurrentWebApplicationContext().getServletContext());
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(response, result);
		return null;
	}
	
}
