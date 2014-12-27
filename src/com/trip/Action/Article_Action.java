package com.trip.Action;

import java.io.File;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Article;
import com.trip.bean.Article_categroy;
import com.trip.bean.Photo;
import com.trip.bean.User;
import com.trip.service.Article_service;

@SuppressWarnings("serial")
public class Article_Action extends ActionSupport {

	private Article article;
	
	private Article_service articel_servive;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Article_service getArticel_servive() {
		return articel_servive;
	}

	public void setArticel_servive(Article_service articelServive) {
		articel_servive = articelServive;
	}
	
//以下为自定义方法	
/**
 * 增加文章	
 */
	public String addArticleAction(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("categroy"));
		if(id==0)
		{
			article.setArticle_categroy(null);
		}
		else
		{
			Article_categroy categroy = new Article_categroy();
			categroy.setId(id);
			article.setArticle_categroy(categroy);
		}
		
		User user = (User)session.getAttribute("user");
		
		if(null==article.getTitle().trim()||""==article.getTitle().trim())
		{
			article.setTitle(new Date().toString());
		}
		if(null==article.getContent().trim()||""==article.getContent().trim())
		{
			this.addActionError("内容不能为空！");
			
			return "addArticle_failture";
		}
		  
		  article.setUser(user);
		  article.setDateline(new Date());
		//保存文章
		this.articel_servive.saveArticle(article);
		
		return "addArticle_success";
		
		
		
	}
/**
 * 显示所有文章
 */
	@SuppressWarnings("unchecked")
	public void showAllArticleAction()throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
        
        
        List list = this.articel_servive.allArticle();
		
        System.out.println("循环前"+list.size());
	    Iterator iter = list.iterator();
	    
	    while(iter.hasNext())
	    {
	    	Article article1 = (Article)iter.next();
	    	//评论数
	    	System.out.println(article1.getTitle());
	    	article1.setComment_count(article1.getArticle_comments().size());
	    	//阅读次数中放入了所属文章用户id
	    	System.out.println("评论数"+article1.getArticle_comments().size());
	    	article1.setRead_count(article1.getUser().getId());
	    	//内容中放入了所属用户的用户名
	    	
	    	article1.setContent(article1.getUser().getUsername());
	    	System.out.println("所属用户名"+article1.getUser().getUsername());
	    	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(article1.getDateline());
			article1.setTime(date);
	    	
			article1.setArticle_categroy(null);
	    	article1.setArticle_comments(null);
	    	article1.setUser(null);
	    	
	    	
	    }
		System.out.println("循环后"+list.size());
	    Gson gson = new Gson();
	    
	    String result = gson.toJson(list);
	    
	    response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println(result);
	    
	    out.flush();
	    
	    
	    
	}
/**
 * 删除文章
 */
	public void deletArticle()throws Exception
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		Article article1 = this.articel_servive.findArticleById(articleId);
		
		this.articel_servive.removeArticle(article1);
		
		Gson gson = new Gson();
		
		String result = "删除成功!";
		
		String result1 = gson.toJson(result);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println(result1);
	    out.flush();
	    
		
	}
/**
 * 根据文章编号查询文章
 */
	public void searchArticleById()throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		Article article1 = this.articel_servive.findArticleById(articleId);
		
		Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("article", article1);
		
		
	}
/**
 * 更新文章
 */
	public String updateArticle(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		int id = Integer.parseInt(request.getParameter("categroy"));
		if(id==0)
		{
			article.setArticle_categroy(null);
		}
		else
		{
			Article_categroy categroy = new Article_categroy();
			categroy.setId(id);
			article.setArticle_categroy(categroy);
		}
		
		User user = (User)session.getAttribute("user");
		
		if(null==article.getTitle().trim()||""==article.getTitle().trim())
		{
			article.setTitle(new Date().toString());
		}
		if(null==article.getContent().trim()||""==article.getContent().trim())
		{
			this.addActionError("内容不能为空！");
			
			return "addArticle_failture";
		}
		  
		  article.setUser(user);
		  article.setDateline(new Date());
		//保存文章
		this.articel_servive.updateArticle(article);

		return "updateArticle_success";
	}
	

/**
 * 根据文章id显示该文章的评论	
 */
	@SuppressWarnings("unchecked")
	public void showComment()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//HttpServletResponse response = ServletActionContext.getResponse();
		
		//System.out.println("attribut"+(String)request.getAttribute("articleId"));
		//System.out.println("parameter"+request.getParameter("articleId"));
		int id = Integer.parseInt((String)request.getAttribute("articleId"));
		
		Article article3 = this.articel_servive.findArticleById(id);
		
		Set list = (Set)article3.getArticle_comments();
		
        Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
	}
	
	
	
	
	
	
/**
 * 以下三个个方法为kindediter插件发表文章时上传本地图片所用的方法	
 */
//////////////////////////////////////////////////////////////////////////	
/**
 * 用于输出Json数据的方法	
 
	
	 @SuppressWarnings("unchecked")
	private String getError(String message) {
		 HttpServletResponse response = ServletActionContext.getResponse();
		
		 response.setContentType("text/html; charset=UTF-8");
		  	JSONObject obj = new JSONObject();
		  	
		  	obj.put("error", 1);
		  	obj.put("message", message);
		  	return obj.toJSONString();
		  }
/**
 * 用于文件上传的方法		  
 * @throws Exception

	 @SuppressWarnings("unchecked") 
  public void upload_json()throws Exception
  {
	  /**
	   * KindEditor JSP
	   * 
	   * 本JSP程序是演示程序，建议不要直接在实际项目中使用。
	   * 如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
	   * 
	  
      
	  HttpServletRequest request=ServletActionContext.getRequest();
	  MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)request;
	  HttpServletResponse response=ServletActionContext.getResponse();
	  PrintWriter out = response.getWriter();

	  //文件保存目录路径
	  //String savePath = ServletActionContext.getRequest().getRealPath("/")+ "attached/";
	  
	  String savePath = ServletActionContext.getServletContext().getRealPath("/")+ "attached/";
	  
	  //String savePath = ServletActionContext.getPageContext().getServletContext().getRealPath("/") + "attached/";
	  System.out.println("savePath:"+savePath);
	  
	  //文件保存目录URL
	  String saveUrl  = wrapper.getContextPath() + "/attached/";
	  System.out.println("saveUrl:"+saveUrl);
	  //定义允许上传的文件扩展名
	  String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};
	  //最大文件大小
	  long maxSize = 1000000;

	  response.setContentType("text/html; charset=UTF-8");
      
	  	  
	  if(!ServletFileUpload.isMultipartContent(request)){
	  	out.println(getError("请选择文件。"));
	  	return;
	  }
	  //检查目录
	  File uploadDir = new File(savePath);
	  if(!uploadDir.isDirectory()){
	  	out.println(getError("上传目录不存在。"));
	  	return;
	  }
	  //检查目录写权限
	  if(!uploadDir.canWrite()){
	  	out.println(getError("上传目录没有写权限。"));
	  	return;
	  }
	  //创建文件夹
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	  String ymd = sdf.format(new Date());
	  savePath += ymd + "/";
	  saveUrl += ymd + "/";
	  File dirFile = new File(savePath);
	  if (!dirFile.exists()) {
	  	dirFile.mkdirs();
	  }

	  FileItemFactory factory = new DiskFileItemFactory();
	  ServletFileUpload upload = new ServletFileUpload(factory);
	  upload.setHeaderEncoding("UTF-8");
	  List items = upload.parseRequest(request);
	  Iterator itr = items.iterator();
	  while (itr.hasNext()) {
	  	FileItem item = (FileItem) itr.next();
	  	String fileName = item.getName();
	  	
	  	@SuppressWarnings("unused")
		long fileSize = item.getSize();
	  	if (!item.isFormField()) {
	  		//检查文件大小
	  		if(item.getSize() > maxSize){
	  			out.println(getError("上传文件大小超过限制。"));
	  			return;
	  		}
	  		//检查扩展名
	  		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	  		if(!Arrays.<String>asList(fileTypes).contains(fileExt)){
	  			out.println(getError("上传文件扩展名是不允许的扩展名。"));
	  			return;
	  		}

	  		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	  		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
	  		try{
	  			File uploadedFile = new File(savePath, newFileName);
	  			item.write(uploadedFile);
	  		}catch(Exception e){
	  			out.println(getError("上传文件失败。"));
	  			return;
	  		}

	  		JSONObject obj = new JSONObject();
	  		obj.put("error", 0);
	  		obj.put("url", saveUrl + newFileName);
	  		out.println(obj.toJSONString());
	  	}
	  }
}
/**
 * 用于处理上传的图片的方法
 
	 @SuppressWarnings("unchecked")
	public class NameComparator  implements Comparator{
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
				}
			}
		}
	 @SuppressWarnings("unchecked")
	public class SizeComparator implements Comparator{
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					if (((Long)hashA.get("filesize")) > ((Long)hashB.get("filesize"))) {
						return 1;
					} else if (((Long)hashA.get("filesize")) < ((Long)hashB.get("filesize"))) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		}
	 
	@SuppressWarnings("unchecked")
	public class TypeComparator implements Comparator{
			public int compare(Object a, Object b) {
				Hashtable hashA = (Hashtable)a;
				Hashtable hashB = (Hashtable)b;
				if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
					return -1;
				} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
					return 1;
				} else {
					return ((String)hashA.get("filetype")).compareTo((String)hashB.get("filetype"));
				}
			}
		}
	@SuppressWarnings("unchecked")
	public void file_manager_json()throws Exception{
		//根目录路径，可以指定绝对路径，比如 /var/www/attached/
		HttpServletRequest request= ServletActionContext.getRequest();
		MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper) request; 
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		String rootPath = ServletActionContext.getServletContext().getRealPath("/")+ "attached/";
		//String rootPath = ServletActionContext.getPageContext().getServletContext().getRealPath("/") + "attached/";
		
		System.out.println("rootPath:"+rootPath);
		String rootUrl  = wrapper.getContextPath() + "/attached/";
		System.out.println("rootPath:"+rootPath);
		//图片扩展名
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

		//根据path参数，设置各路径和URL
		String path = wrapper.getParameter("path") != null ? request.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		//排序形式，name or size or type
		String order = wrapper.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

		//不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			out.println("Access is not allowed.");
			return;
		}
		//最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			out.println("Parameter is not valid.");
			return;
		}
		//目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if(!currentPathFile.isDirectory()){
			out.println("Directory does not exist.");
			return;
		}

		//遍历目录取的文件信息
		List<Hashtable> fileList = new ArrayList<Hashtable>();
		if(currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if(file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if(file.isFile()){
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String>asList(fileTypes).contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file.lastModified()));
				fileList.add(hash);
			}
		}
           
		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		JSONObject result = new JSONObject();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);

		response.setContentType("application/json; charset=UTF-8");
		out.println(result.toJSONString());
		
		
		
		
	
			}
	
*/	
	
	
	
	
	
	
	
}
