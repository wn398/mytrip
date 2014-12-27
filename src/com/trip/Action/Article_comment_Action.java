package com.trip.Action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Article;
import com.trip.bean.Article_comment;
import com.trip.bean.Photo;
import com.trip.service.Article_comment_service;

@SuppressWarnings("serial")
public class Article_comment_Action extends ActionSupport {
	
	private Article_comment article_comment;
	
	private Article_comment_service article_comment_service;

	public Article_comment getArticle_comment() {
		return article_comment;
	}

	public void setArticle_comment(Article_comment articleComment) {
		article_comment = articleComment;
	}

	public Article_comment_service getArticle_comment_service() {
		return article_comment_service;
	}

	public void setArticle_comment_service(
			Article_comment_service articleCommentService) {
		article_comment_service = articleCommentService;
	}
	
	
	
/**
 * 增加评论 AJAX	
 */
  public void addComment()throws Exception
  {
	  HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpServletResponse response = ServletActionContext.getResponse();
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		Article article = new Article();
		
		article.setId(articleId);
		
		article_comment.setArticle(article);
		
		article_comment.setComment_time(new Date());
		
		this.article_comment_service.saveArticle_comment(article_comment);
		
       Gson gson = new Gson();
		
		String result = "评论成功";
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
	
/**
 * 删除文章评论     AJAX	
 */
public void deleteComment()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("commentId"));
	
	this.article_comment_service.removeArticle_comment(this.article_comment_service.findArticle_commentById(id));

	Gson gson = new Gson();
	
	String result = "删除文章评论成功";
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
