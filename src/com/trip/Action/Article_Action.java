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
	
//����Ϊ�Զ��巽��	
/**
 * ��������	
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
			this.addActionError("���ݲ���Ϊ�գ�");
			
			return "addArticle_failture";
		}
		  
		  article.setUser(user);
		  article.setDateline(new Date());
		//��������
		this.articel_servive.saveArticle(article);
		
		return "addArticle_success";
		
		
		
	}
/**
 * ��ʾ��������
 */
	@SuppressWarnings("unchecked")
	public void showAllArticleAction()throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
        
        
        List list = this.articel_servive.allArticle();
		
        System.out.println("ѭ��ǰ"+list.size());
	    Iterator iter = list.iterator();
	    
	    while(iter.hasNext())
	    {
	    	Article article1 = (Article)iter.next();
	    	//������
	    	System.out.println(article1.getTitle());
	    	article1.setComment_count(article1.getArticle_comments().size());
	    	//�Ķ������з��������������û�id
	    	System.out.println("������"+article1.getArticle_comments().size());
	    	article1.setRead_count(article1.getUser().getId());
	    	//�����з����������û����û���
	    	
	    	article1.setContent(article1.getUser().getUsername());
	    	System.out.println("�����û���"+article1.getUser().getUsername());
	    	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(article1.getDateline());
			article1.setTime(date);
	    	
			article1.setArticle_categroy(null);
	    	article1.setArticle_comments(null);
	    	article1.setUser(null);
	    	
	    	
	    }
		System.out.println("ѭ����"+list.size());
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
 * ɾ������
 */
	public void deletArticle()throws Exception
	{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		
		Article article1 = this.articel_servive.findArticleById(articleId);
		
		this.articel_servive.removeArticle(article1);
		
		Gson gson = new Gson();
		
		String result = "ɾ���ɹ�!";
		
		String result1 = gson.toJson(result);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	    
	    PrintWriter out = response.getWriter();
	    
	    out.println(result1);
	    out.flush();
	    
		
	}
/**
 * �������±�Ų�ѯ����
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
 * ��������
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
			this.addActionError("���ݲ���Ϊ�գ�");
			
			return "addArticle_failture";
		}
		  
		  article.setUser(user);
		  article.setDateline(new Date());
		//��������
		this.articel_servive.updateArticle(article);

		return "updateArticle_success";
	}
	

/**
 * ��������id��ʾ�����µ�����	
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
 * ��������������Ϊkindediter�����������ʱ�ϴ�����ͼƬ���õķ���	
 */
//////////////////////////////////////////////////////////////////////////	
/**
 * �������Json���ݵķ���	
 
	
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
 * �����ļ��ϴ��ķ���		  
 * @throws Exception

	 @SuppressWarnings("unchecked") 
  public void upload_json()throws Exception
  {
	  /**
	   * KindEditor JSP
	   * 
	   * ��JSP��������ʾ���򣬽��鲻Ҫֱ����ʵ����Ŀ��ʹ�á�
	   * �����ȷ��ֱ��ʹ�ñ�����ʹ��֮ǰ����ϸȷ����ذ�ȫ���á�
	   * 
	  
      
	  HttpServletRequest request=ServletActionContext.getRequest();
	  MultiPartRequestWrapper wrapper = (MultiPartRequestWrapper)request;
	  HttpServletResponse response=ServletActionContext.getResponse();
	  PrintWriter out = response.getWriter();

	  //�ļ�����Ŀ¼·��
	  //String savePath = ServletActionContext.getRequest().getRealPath("/")+ "attached/";
	  
	  String savePath = ServletActionContext.getServletContext().getRealPath("/")+ "attached/";
	  
	  //String savePath = ServletActionContext.getPageContext().getServletContext().getRealPath("/") + "attached/";
	  System.out.println("savePath:"+savePath);
	  
	  //�ļ�����Ŀ¼URL
	  String saveUrl  = wrapper.getContextPath() + "/attached/";
	  System.out.println("saveUrl:"+saveUrl);
	  //���������ϴ����ļ���չ��
	  String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};
	  //����ļ���С
	  long maxSize = 1000000;

	  response.setContentType("text/html; charset=UTF-8");
      
	  	  
	  if(!ServletFileUpload.isMultipartContent(request)){
	  	out.println(getError("��ѡ���ļ���"));
	  	return;
	  }
	  //���Ŀ¼
	  File uploadDir = new File(savePath);
	  if(!uploadDir.isDirectory()){
	  	out.println(getError("�ϴ�Ŀ¼�����ڡ�"));
	  	return;
	  }
	  //���Ŀ¼дȨ��
	  if(!uploadDir.canWrite()){
	  	out.println(getError("�ϴ�Ŀ¼û��дȨ�ޡ�"));
	  	return;
	  }
	  //�����ļ���
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
	  		//����ļ���С
	  		if(item.getSize() > maxSize){
	  			out.println(getError("�ϴ��ļ���С�������ơ�"));
	  			return;
	  		}
	  		//�����չ��
	  		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	  		if(!Arrays.<String>asList(fileTypes).contains(fileExt)){
	  			out.println(getError("�ϴ��ļ���չ���ǲ��������չ����"));
	  			return;
	  		}

	  		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
	  		String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
	  		try{
	  			File uploadedFile = new File(savePath, newFileName);
	  			item.write(uploadedFile);
	  		}catch(Exception e){
	  			out.println(getError("�ϴ��ļ�ʧ�ܡ�"));
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
 * ���ڴ����ϴ���ͼƬ�ķ���
 
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
		//��Ŀ¼·��������ָ������·�������� /var/www/attached/
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
		//ͼƬ��չ��
		String[] fileTypes = new String[]{"gif", "jpg", "jpeg", "png", "bmp"};

		//����path���������ø�·����URL
		String path = wrapper.getParameter("path") != null ? request.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0, currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0, str.lastIndexOf("/") + 1) : "";
		}

		//������ʽ��name or size or type
		String order = wrapper.getParameter("order") != null ? request.getParameter("order").toLowerCase() : "name";

		//������ʹ��..�ƶ�����һ��Ŀ¼
		if (path.indexOf("..") >= 0) {
			out.println("Access is not allowed.");
			return;
		}
		//���һ���ַ�����/
		if (!"".equals(path) && !path.endsWith("/")) {
			out.println("Parameter is not valid.");
			return;
		}
		//Ŀ¼�����ڻ���Ŀ¼
		File currentPathFile = new File(currentPath);
		if(!currentPathFile.isDirectory()){
			out.println("Directory does not exist.");
			return;
		}

		//����Ŀ¼ȡ���ļ���Ϣ
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
