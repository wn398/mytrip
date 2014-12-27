package com.trip.Action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Article;
import com.trip.bean.Article_categroy;
import com.trip.bean.User;
import com.trip.service.Article_categroy_service;

@SuppressWarnings("serial")
public class Article_categroy_Action extends ActionSupport {
	
	private Article_categroy article_categroy;
	
	private Article_categroy_service article_categroy_service;

	public Article_categroy getArticle_categroy() {
		return article_categroy;
	}

	public void setArticle_categroy(Article_categroy articleCategroy) {
		article_categroy = articleCategroy;
	}

	public Article_categroy_service getArticle_categroy_service() {
		return article_categroy_service;
	}

	public void setArticle_categroy_service(
			Article_categroy_service articleCategroyService) {
		article_categroy_service = articleCategroyService;
	}
/**
 * 以下为自定义方法
 */

/**
 * 增加文章分类
 */
	public void add_catergroy()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		//System.out.println(album.getAlbum_name().trim()+"123");
		
		if(null == article_categroy.getCategroy_name().trim()||"".equals(article_categroy.getCategroy_name().trim()))
		{
			
			
			this.addActionError("文章分类名称不能为空");
			
					
			Gson gson = new Gson();
			
			String result = "<img src='imageutil/warning.png'>相册名称不能为空！";
			//System.out.println(user3.getUsername());
			String result1 = gson.toJson(result);
			
			//String result = user3.getQuestion();
			//设置向页面的传输方式与缓存设置
	        
			response.setContentType("application/json; charset=utf-8");
		    response.setHeader("pragma", "no-cache");
		    response.setHeader("cache-control", "no-cache");
		   
	        PrintWriter out = response.getWriter();
			
			out.println(result1);
			
			out.flush();
		}
		else
		{
			article_categroy.setUser(user);
		   
			this.article_categroy_service.saveArticle_categroy(article_categroy);
			
			Gson gson = new Gson();
			
			String result = "  <img src='imageutil/accept.png'>新建分类成功！";
			//System.out.println(user3.getUsername());
			String result1 = gson.toJson(result);
			
			//String result = user3.getQuestion();
			//设置向页面的传输方式与缓存设置
	        
			response.setContentType("application/json; charset=utf-8");
		    response.setHeader("pragma", "no-cache");
		    response.setHeader("cache-control", "no-cache");
		   
	        PrintWriter out = response.getWriter();
			
			out.println(result1);
			
			out.flush();
		}
		
		
	}

	
/**
 * 通过分类显示该分类下的所有文章
 */
	@SuppressWarnings({ "unchecked", "null" })
	public void showCategroyArticle()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		int categroyId = Integer.parseInt((String)request.getParameter("categroyId"));
		System.out.println("分类名称："+categroyId);
		
		Article_categroy categroy =this.article_categroy_service.findArticle_categroyById(categroyId);
		
		Set<Article> articleList = categroy.getArticles();
		
		List<Article> list = new ArrayList<Article>();
		
		Iterator iter = articleList.iterator();
		
		while(iter.hasNext())
		{
			Article article = (Article)iter.next();
			
			Article article1 = new Article();
			
			article1.setArticle_categroy(null);
			article1.setArticle_comments(null);
			article1.setComment_count(article.getComment_count());
			
			//由于日期格式的处理在js中相当麻烦所以将日期以字符串形式放在了内容中以方便调用
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(article.getDateline());
			
			article1.setContent(date);
			article1.setDateline(null);
			
			article1.setId(article.getId());
			article1.setRead_count(article.getRead_count());
			article1.setTitle(article.getTitle());
			article1.setUser(null);
			
			list.add(article1);
		}
		
		Gson gson = new Gson();
		
		System.out.println(list.size());
		
		//System.out.println(user3.getUsername());
		//String result1 = gson.toJson(articleList);
		
		//String result = user3.getQuestion();
		//设置向页面的传输方式与缓存设置
		/*
		String[] result1 = null;
		int i=-1;
		Iterator iter = articleList.iterator();
		while(iter.hasNext())
		{
			Article article = (Article)iter.next();
			String article1 = gson.toJson(article);
			result1[++i]=article1;
		}
        */
		String result1 = gson.toJson(list);
		
		System.out.println("结果"+result1);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	   
        PrintWriter out = response.getWriter();
		
		out.println(result1);
		
		out.flush();
		//Map request1 = (Map) ActionContext.getContext().get("request");
		
		//request1.put("list", articleList);
	}
	
	
}
