package com.trip.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Album;
import com.trip.bean.Photo;
import com.trip.bean.User;
import com.trip.service.Photo_service;

@SuppressWarnings("serial")
public class Photo_Action extends ActionSupport {
  
	private Photo photo;
	
	private Photo_service photo_service;
    
    private List<File> file;
	
    private List<String> fileFileName;
	
	private List<String> fileContentType;
	
	
	
	public List<File> getFile() {
		return file;
	}

	public void setFile(List<File> file) {
		this.file = file;
	}

	public List<String> getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}

	public List<String> getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Photo_service getPhoto_service() {
		return photo_service;
	}

	public void setPhoto_service(Photo_service photoService) {
		photo_service = photoService;
	}
	
/**
 * 添加相片
 */
	@SuppressWarnings("deprecation")
	public void addPhotoAction()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		//HttpSession session = request.getSession();
		
		
		//从uploadify中获得参数，只能是字符串类型的
		
		int userid = Integer.parseInt(request.getParameter("user"));
		
		String username1 = request.getParameter("username");
		
		//System.out.println(request.getParameter("album"));
		
		int album_id = Integer.parseInt(request.getParameter("album"));
		
		//System.out.println("用户id为："+userid);
		
		//System.out.println("用户名："+username1);
		
		//System.out.println("相册id为："+album_id);
		
		for(int i=0;i<file.size();i++)
		{
			//String rename = user1.getUsername();
			
			//int j = fileFileName.get(i).lastIndexOf(".");
			
			//String type=fileFileName.get(i).substring(j);
			  		   
			InputStream is=new FileInputStream(file.get(i));
			
			String root=ServletActionContext.getRequest().getRealPath("/upload/image");
			//获得文件后缀名
			int j = fileFileName.get(i).lastIndexOf(".");
			String type=fileFileName.get(i).substring(j);
			
			
			//获得日期字符串
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(new Date()).toString().replace("-","").replace(":","").replace(" ","");
			//获得随机数字符串
			Random rd = new Random();
			String random = rd.nextInt(100000)+"";
			//目标文件名
			String fname = username1+"-"+date+"-"+random+type;
			
			File destFile = new File (root,fname);
			
			OutputStream os=new FileOutputStream(destFile);
			
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			while(-1 != (length = is.read(buffer)))
			{
				os.write(buffer, 0, length);
			}
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
            PrintWriter out = ServletActionContext.getResponse().getWriter(); 
			//向客户端传回两个参数，相应上传的图片地址和图片所在的相册id
			out.println("upload/image/"+fname+"@"+album_id);
			is.close();
			os.close();
			
			
           
			//把图片名称存入数据库中,构建用户对象
			User user1=new User();
			user1.setId(userid);
			user1.setUsername(username1);
			//通过ognl方式struts2不能获得相应的对象，所以手动创建
			Album album = new Album();
			
			album.setId(album_id);
			
			Photo photo1 = new Photo();
			
   		    photo1.setPersonal_photo(fname);
   		    
   		    photo1.setAlbum(album);
			
			photo1.setUser(user1);
			
			this.photo_service.savePhoto(photo1);
			
			
			
			
			//int id=user1.getId();
			
			//System.out.println(id);
			
			//User user2=this.user_service.findUserById(id);
			
			//user2.setAvatar(rename+type);
			
			//this.user_service.updateUser(user2);
			
			//ActionContext.getContext().getSession().put("user", user2);
			
		}
		
	}

/**
 * 更新相片（主要为添加相片介绍）	
 */
	public void updatePhoto()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		System.out.println(photo.getPhoto_introduction().trim()+"123");
		
		if(null == photo.getPhoto_introduction().trim()||"".equals(photo.getPhoto_introduction().trim()))
		{
			
			
			this.addActionError("相片介绍不能为空");
			
					
			Gson gson = new Gson();
			
			String result = "<img src='imageutil/warning.png'>相片介绍不能为空！";
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
			Photo photo1= this.photo_service.findPhotoById(photo.getId());
		
			photo1.setPhoto_introduction(photo.getPhoto_introduction());
			
			this.photo_service.updatePhoto(photo1);
			
			Gson gson = new Gson();
			
			String result = "  <img src='imageutil/accept.png'>保存相片介绍成功！";
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
 * 单个相片删除
 */
	public void deletePhoto()throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		//HttpServletRequest request = ServletActionContext.getRequest();
	
		
		Photo photo1=this.photo_service.findPhotoById(photo.getId());
		
		this.photo_service.removePhoto(photo1);
		
		Gson gson = new Gson();
		
		String result = "删除成功";
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
 * 加载对应相片的评论	
 */
	@SuppressWarnings("unchecked")
	public void showComment()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		
		System.out.println((String)request.getAttribute("photoId"));
		
		int id = Integer.parseInt((String)request.getAttribute("photoId"));
		
		Photo photo3 = this.photo_service.findPhotoById(id);
		
		Set list = (Set)photo3.getPhoto_comments();
		
        Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
	}
/**
 * 所有的相片  AJAX	
 */
public void allPhoto()throws Exception
{
	HttpServletResponse response = ServletActionContext.getResponse();
	
	List list = this.photo_service.allPhoto();
	
	Iterator iter = list.iterator();
	System.out.println("循环前"+list.size());
	while(iter.hasNext())
	{
		Photo photo1 = (Photo)iter.next();
		//将相片主人名放在此中
		photo1.setPhoto_user(photo1.getUser().getUsername());
		System.out.println("用户名"+photo1.getUser().getUsername());
		//将相片主人的id号放在此中
		photo1.setUser_id(photo1.getUser().getId());
		
		//将相片的评论数放在此中
		photo1.setPhoto_introduction(String.valueOf(photo1.getPhoto_comments().size()));
		photo1.setAlbum(null);
		photo1.setPhoto_comments(null);
		photo1.setUser(null);
	}
	
	Gson gson = new Gson();
	
	String result1 = gson.toJson(list);
	
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
