package com.trip.Action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Photo;
import com.trip.bean.Photo_comment;
import com.trip.service.Photo_comment_service;

@SuppressWarnings("serial")
public class Photo_comment_Action extends ActionSupport {
   
	private Photo_comment photo_comment;
	
	private Photo_comment_service photo_comment_service;

	public Photo_comment getPhoto_comment() {
		return photo_comment;
	}

	public void setPhoto_comment(Photo_comment photoComment) {
		photo_comment = photoComment;
	}

	public Photo_comment_service getPhoto_comment_service() {
		return photo_comment_service;
	}

	public void setPhoto_comment_service(Photo_comment_service photoCommentService) {
		photo_comment_service = photoCommentService;
	}
	
	
	
/**
 * 增加评论	AJAX
 */
	public void addComment()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpServletResponse response = ServletActionContext.getResponse();
		int photoId = Integer.parseInt(request.getParameter("photoId"));
		
		Photo photo = new Photo();
		
		photo.setId(photoId);
		
		photo_comment.setPhoto(photo);
		
		photo_comment.setComment_time(new Date());
		
		this.photo_comment_service.savePhoto_comment(photo_comment);
		
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
 * 删除相片评论　ＡＪＡＸ	
 */

public void deleteComment()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("commentId"));
	
	this.photo_comment_service.removePhoto_comment(this.photo_comment_service.findPhoto_commentById(id));
 
    Gson gson = new Gson();
    
    String result = "删除相片评论成功！";
    
    String result1 = gson.toJson(result);
    
    response.setContentType("application/Json;charset=utf-8");
    response.setHeader("pragma", "no-catch");
    response.setHeader("cache-control", "no-cache");
    
    PrintWriter out = response.getWriter();
    
    out.println(result1);
    
    out.flush();
}

}
