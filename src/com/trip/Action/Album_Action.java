package com.trip.Action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

import com.google.gson.Gson;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Album;
import com.trip.bean.Photo;
import com.trip.bean.User;
import com.trip.service.Album_service;
import com.trip.service.Photo_service;
import com.trip.service.Impl.Photo_service_Impl;

@SuppressWarnings("serial")
public class Album_Action extends ActionSupport {

	private Album album;
	
	private Album_service album_service;

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Album_service getAlbum_service() {
		return album_service;
	}

	public void setAlbum_service(Album_service albumService) {
		album_service = albumService;
	}
	
	
	/**
	 * 显示相册
	 */
	@SuppressWarnings("unchecked")
	public String showMyPhoto()throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		//User user = (User)session.getAttribute("user");
		
		int id = Integer.parseInt(request.getParameter("album.id"));
		
		System.out.println(id);
		
		Album album1 = this.album_service.findAlbumById(id);
		
		System.out.println("相册名为："+album1.getAlbum_name());
		System.out.println("相片数为："+album1.getPhotos().size());
		//Hibernate.initialize(album1);
		
		Set<Photo> list = (Set)album1.getPhotos();
		
		Hibernate.initialize(list);
		
		if(list.isEmpty())
		{
			Photo photo = new Photo();
			photo.setId(0);
			photo.setPhoto_introduction("没有相片！");
			
			
			list.add(photo);
		}
		
		
		Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
		
		return "showPhoto_success";
	}
	
	/**
	 * 增加相册
	 */
	public void addAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		//System.out.println(album.getAlbum_name().trim()+"123");
		
		if(null == album.getAlbum_name().trim()||"".equals(album.getAlbum_name().trim()))
		{
			
			
			this.addActionError("相册名称不能为空");
			
					
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
			album.setUser(user);
			
			album.setAlbum_dateline(new Date());
			
			this.album_service.saveAlbum(album);
			
			Gson gson = new Gson();
			
			String result = "  <img src='imageutil/accept.png'>新建相册成功！";
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
	 * 删除相册
	 */
	public String delAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("album.id"));
	    System.out.println("相册id为："+id);
	    
		//album.setId(id);
        //如果只采用上面语句album.setId(id)而不去查询（下面语句）删除的结果为只删除了本表及级联表中的关联字段
	    //而采用查询出来的删除则会级联删除（表中已经设置了级联删除）原因可能是查询出来的语句中有级联对象的集合吧
	    album = this.album_service.findAlbumById(id);
//		
//		
		
//		 
		//Hibernate.initialize(album.getPhotos());
//		
//		System.out.println(list.size());
//		
	   
//		
 		
        
 		
 		//Map request1 = (Map) ActionContext.getContext().get("request");
		
		//request1.put("list", list);
		
		this.album_service.removeAlbum(album);
		
		//在之前下面的代码段放在上面这句语句前老是报延迟加载的错，看来真正的执行是在这句语句发出之后啊
		Set list = album.getPhotos();
		
		Iterator iter = list.iterator();
		
		while(iter.hasNext())
		{
			Photo photo = (Photo)iter.next();
			
			//获取图片所在路径
			String root=ServletActionContext.getRequest().getRealPath("/upload/image/");
			//得到文件名
			String filename = photo.getPersonal_photo();
			
			//在硬盘上删除图片文件			
			File  str_file = new  File(root,filename);//path应该是服务器上文件的绝对路径； 
			
			if (str_file.exists()) 
			      
	             str_file.delete();
			}
		
		
		return "delAlbum_success";
	}
	/**
	 * 更新相册
	 */
	public void updateAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Album album1 = this.album_service.findAlbumById(album.getId());
		
		album1.setCover_picture(album.getCover_picture());
		
		this.album_service.updateAlbum(album1);
		
         Gson gson = new Gson();
		
		String result = "设置封面成功";
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
 * 	
 */
}   
