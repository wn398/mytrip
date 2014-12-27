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
	 * ��ʾ���
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
		
		System.out.println("�����Ϊ��"+album1.getAlbum_name());
		System.out.println("��Ƭ��Ϊ��"+album1.getPhotos().size());
		//Hibernate.initialize(album1);
		
		Set<Photo> list = (Set)album1.getPhotos();
		
		Hibernate.initialize(list);
		
		if(list.isEmpty())
		{
			Photo photo = new Photo();
			photo.setId(0);
			photo.setPhoto_introduction("û����Ƭ��");
			
			
			list.add(photo);
		}
		
		
		Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
		
		return "showPhoto_success";
	}
	
	/**
	 * �������
	 */
	public void addAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		//System.out.println(album.getAlbum_name().trim()+"123");
		
		if(null == album.getAlbum_name().trim()||"".equals(album.getAlbum_name().trim()))
		{
			
			
			this.addActionError("������Ʋ���Ϊ��");
			
					
			Gson gson = new Gson();
			
			String result = "<img src='imageutil/warning.png'>������Ʋ���Ϊ�գ�";
			//System.out.println(user3.getUsername());
			String result1 = gson.toJson(result);
			
			//String result = user3.getQuestion();
			//������ҳ��Ĵ��䷽ʽ�뻺������
	        
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
			
			String result = "  <img src='imageutil/accept.png'>�½����ɹ���";
			//System.out.println(user3.getUsername());
			String result1 = gson.toJson(result);
			
			//String result = user3.getQuestion();
			//������ҳ��Ĵ��䷽ʽ�뻺������
	        
			response.setContentType("application/json; charset=utf-8");
		    response.setHeader("pragma", "no-cache");
		    response.setHeader("cache-control", "no-cache");
		   
	        PrintWriter out = response.getWriter();
			
			out.println(result1);
			
			out.flush();
		}
}
	
	
	/**
	 * ɾ�����
	 */
	public String delAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("album.id"));
	    System.out.println("���idΪ��"+id);
	    
		//album.setId(id);
        //���ֻ�����������album.setId(id)����ȥ��ѯ��������䣩ɾ���Ľ��Ϊֻɾ���˱����������еĹ����ֶ�
	    //�����ò�ѯ������ɾ����ἶ��ɾ���������Ѿ������˼���ɾ����ԭ������ǲ�ѯ������������м�������ļ��ϰ�
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
		
		//��֮ǰ����Ĵ���η�������������ǰ���Ǳ��ӳټ��صĴ�����������ִ�����������䷢��֮��
		Set list = album.getPhotos();
		
		Iterator iter = list.iterator();
		
		while(iter.hasNext())
		{
			Photo photo = (Photo)iter.next();
			
			//��ȡͼƬ����·��
			String root=ServletActionContext.getRequest().getRealPath("/upload/image/");
			//�õ��ļ���
			String filename = photo.getPersonal_photo();
			
			//��Ӳ����ɾ��ͼƬ�ļ�			
			File  str_file = new  File(root,filename);//pathӦ���Ƿ��������ļ��ľ���·���� 
			
			if (str_file.exists()) 
			      
	             str_file.delete();
			}
		
		
		return "delAlbum_success";
	}
	/**
	 * �������
	 */
	public void updateAlbum()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		Album album1 = this.album_service.findAlbumById(album.getId());
		
		album1.setCover_picture(album.getCover_picture());
		
		this.album_service.updateAlbum(album1);
		
         Gson gson = new Gson();
		
		String result = "���÷���ɹ�";
		//System.out.println(user3.getUsername());
		String result1 = gson.toJson(result);
		
		//String result = user3.getQuestion();
		//������ҳ��Ĵ��䷽ʽ�뻺������
        
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
