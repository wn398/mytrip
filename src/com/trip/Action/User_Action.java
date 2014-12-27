package com.trip.Action;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

import sun.rmi.transport.proxy.HttpReceiveSocket;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.Servlet.ValidationCode;
import com.trip.bean.Album;
import com.trip.bean.Article;
import com.trip.bean.Article_categroy;
import com.trip.bean.Friend;
import com.trip.bean.Friend_categroy;
import com.trip.bean.User;
import com.trip.service.User_service;

@SuppressWarnings("serial")
public class User_Action extends ActionSupport {
	/**
	 * ����ʵ��user�� ������User_service
	 */
    private User user;
    
    private User_service user_service;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User_service getUser_service() {
		return user_service;
	}

	public void setUser_service(User_service userService) {
		user_service = userService;
	}
	
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	/**
	 * ����Ϊ�ϴ��ļ�׼������������
	 */
    private File file;
	
    private String fileFileName;
	
	private String fileContentType;
	
/**
 * ����Ϊ�Զ��巽��
 */
/**
 * ע��Action	
 */
	public String registerAction()throws Exception{
		
		user.setRegister_time(new Date());
		
		this.user_service.saveUser(user);
		
		return "register_success";
	}
/**
 * 
 * registerAction��У�鷽��
 * 
 **/
	public void validateRegisterAction() {
		HttpServletRequest request=ServletActionContext.getRequest();
		String username=user.getUsername();
		String password=user.getPassword();
		String repassword=user.getRepassword();
		String question=user.getQuestion();
		String answer=user.getAnswer();
		String validationCode = request.getParameter("validation_code");
		
		if("".equals(username)||null==username)
		{
			this.addActionError("�û�������Ϊ��");
		}
		
		if(!(this.user_service.findUserByName(username).isEmpty()))
		{
			this.addActionError("���û����Ѿ�ע��");
			return ;
		}
		
		if("".equals(password)||null==password)
		{
			this.addActionError("���벻��Ϊ��");
		}
		if(!password.equals(repassword))
		{
			this.addActionError("���벻һ�£�");
		}
		if("".equals(question)||null==question)
		{
			this.addActionError("�������ⲻ��Ϊ�գ�");
		}
		if("".equals(answer)||null==answer)
		{
			this.addActionError("����𰸲���Ϊ��");
		}
		//��֤У����
		if(!ValidationCode.checkValidationCode(request, validationCode))
		{
			this.addActionError("У�����������");
			System.out.println(validationCode);
			return ;
		}
		
	}
/**
 * ��½Action
 */
	public String loadAction()throws Exception{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String username=request.getParameter("username");
		
		//System.out.println(username);
		
		String password=request.getParameter("password");
		
		List<User> list=this.user_service.findUserByName(username);
		
		//System.out.println(list.size());
		if(list.isEmpty())
		{
			this.addActionError("�����ڵ��û�������ע�ᣡ");
			return "load_failure";
		}
		for(int i=0;i<list.size();i++)
		{
			User user=(User)list.get(i);
			if(user.getUsername().equals(username)&&user.getPassword().equals(password))
			{
				//���û���Ϣ����session��
				ActionContext.getContext().getSession().put("user", user);
				
				
			}
			else
			{
			  this.addActionError("����������������룡");
			  return "load_failure";	
			}
		}
		return "load_success";
	}
/**
 * ���¸�����ϢAction	
 */
	
	public String updateAction() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest(); 
        
		HttpSession session = request.getSession();
        
		User user2 = (User)session.getAttribute("user");
		
		int id=user2.getId();
		
		User user1 =(User) this.user_service.findUserById(id);
		
		//String nick_name = request.getParameter("user.nick_name");
		
		user1.setNick_name(user.getNick_name());
		
		//String birthday = request.getParameter("uesr.birthday");
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		//Date dt = df.parse(birthday);
		
		user1.setBirthday(user.getBirthday());
		
		//Boolean sex = Boolean.valueOf(request.getParameter("user.sex")).booleanValue();
		
		user1.setSex(user.isSex());
		
		//String introduction = request.getParameter("user.self_introduction");
		
		user1.setSelf_introduction(user.getSelf_introduction());
		
		//String address = request.getParameter("user.address");
		
		user1.setAddress(user.getAddress());
		
		//String email = request.getParameter("user.email");
		
		user1.setEmail(user.getEmail());
		
		this.user_service.updateUser(user1);
		
		ActionContext.getContext().getSession().put("user", user1);
		
		return "update_success";
	}

	
	
/**
 * �ϴ�ͷ���Action
 */
	@SuppressWarnings("deprecation")
	
	public String updateAavatarAction() throws Exception{
       
		//��session�л��user����
		HttpServletRequest request = ServletActionContext.getRequest(); 
        
		HttpSession session = request.getSession();
        
		User user1 = (User)session.getAttribute("user");
		
		
			String rename = user1.getUsername();
			
			int j = fileFileName.lastIndexOf(".");
			
			String type=fileFileName.substring(j);
			  		   
			InputStream is=new FileInputStream(file);
			
			String root=ServletActionContext.getRequest().getRealPath("/upload/avatar");
			
			File destFile = new File(root,rename+type);
			//File destFile = new File (root,rename);
			
			OutputStream os=new FileOutputStream(destFile);
			
			byte[] buffer = new byte[1024];
			
			int length = 0;
			
			while(-1 != (length = is.read(buffer)))
			{
				os.write(buffer, 0, length);
			}
			is.close();
			os.close();
			
			int id=user1.getId();
			
			//��ͼƬ���������ݿ�			
			User user2=this.user_service.findUserById(id);
			
			user2.setAvatar(rename+type);
			
			this.user_service.updateUser(user2);
			
			//����session�е�user;
			ActionContext.getContext().getSession().put("user", user2);
		
	     	return "updateAvatar_success";
	
	}
/**
 * Ѱ�������Action
 */
	
	public void findPassword()throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		HttpSession session = request.getSession();
		
		if(request.getParameter("username")!= null)
		{
			String name = request.getParameter("username");
			List<User> list=this.user_service.findUserByName(name);
			System.out.println(list.size());
			if(list.isEmpty())
			{
				String[] result = {"�����ڵ��û���������"};
				
				Gson gson = new Gson();
				//System.out.println(user3.getUsername());
				String result1 = gson.toJson(result);
				
				//String result = user3.getQuestion();
				//������ҳ��Ĵ��䷽ʽ�뻺������
		        
				response.setContentType("application/json; charset=utf-8");
			    response.setHeader("pragma", "no-cache");
			    response.setHeader("cache-control", "no-cache");
			   
		        PrintWriter out = response.getWriter();
				
				out.println(result1);
				
				return;
			}
			else
			
		{
			User user3 = list.get(0);
			
			ActionContext.getContext().getSession().put("user.answer", user3.getAnswer());
			
			//System.out.println(user3.getAnswer());
			
			ActionContext.getContext().getSession().put("user.password", user3.getPassword());
			
			//System.out.println(user3.getPassword());
			
			String[] result = {user3.getQuestion()};
			
			Gson gson = new Gson();
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
		
	if(request.getParameter("answer")!=null)
		{
			//System.out.println((String)session.getAttribute("user.answer"));
			//System.out.println(request.getParameter("answer"));
			if(session.getAttribute("user.answer").toString().trim().equals(request.getParameter("answer").toString().trim()))
			{
				Gson gson = new Gson();
				//System.out.println(user3.getUsername());
				String[] result ={(String)session.getAttribute("user.password")};
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
				String[] result = {"�������𰸲���ȷ������һ��"};
				
				Gson gson = new Gson();
				String result1 = gson.toJson(result);
				
				response.setContentType("application/json; charset=utf-8");
			    response.setHeader("pragma", "no-cache");
			    response.setHeader("cache-control", "no-cache");
			   
		        PrintWriter out = response.getWriter();
				
				out.println(result1);
				
				out.flush();
				
			}
		}
	}
	
/**
 * 	��ʾ�ҵ�������
 */
@SuppressWarnings("unchecked")
public String showMyAlbum()throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		//User user = (User)session.getAttribute("user");
		//int id = user.getId();
		
		//���������л�õ�idת��������
		int id = Integer.parseInt(request.getAttribute("userId").toString());
		
		User user1 = this.user_service.findUserById(id);
		
		Set<Album> list = (Set)user1.getAlbums();
		/*
		if(list.isEmpty())
		{
			Album album = new Album();
			album.setId(0);
			album.setAlbum_name("Ĭ�����");
			album.setAlbum_introduction("Ĭ�����");
			
			list.add(album);
		}
		*/
		
		Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
		return "showMyAlbum_success";
	}


/**
 *��ʾ���µķ��� 
  */
@SuppressWarnings("unchecked")
public String showArticleCategroy()throws Exception
{
	
	HttpServletRequest request = ServletActionContext.getRequest();
	//HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	
	//User user = (User)session.getAttribute("user");
	//int id = user.getId();
	
	int id = Integer.parseInt(request.getAttribute("userId").toString());
	
	User user1 = this.user_service.findUserById(id);
	
	Set<Article_categroy> list = (Set)user1.getArticle_categroy();
	
	
	
	if(list.isEmpty())
	{
		Article_categroy article_categroy = new Article_categroy();
		article_categroy.setId(0);
		article_categroy.setCategroy_name("Ĭ�Ϸ���");
		
		
		list.add(article_categroy);
	}
	
	
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	request1.put("list", list);
	
	//System.out.println(list.size());
	
	
	
	return "showArticleCategroy_success";
	
}
/**
 * ��ʾ���û�����������ͨ��ҳ����������
 */
@SuppressWarnings("unchecked")
public void showAllArticle()throws Exception
 {
	
	HttpServletRequest request = ServletActionContext.getRequest();
	//HttpServletResponse response = ServletActionContext.getResponse();
	HttpSession session = request.getSession();
	
	//User user = (User)session.getAttribute("user");
	//int id = user.getId();
	int id = Integer.parseInt(request.getAttribute("userId").toString());
	
	User user1 = this.user_service.findUserById(id);
	
	Set<Article> list = (Set)user1.getArticles();
	
	
	
	
	if(list.isEmpty())
	{
		Article  article = new Article();
		article.setId(0);
		article.setTitle("û������");
		article.setComment_count(0);
		article.setContent("�㻹û���������Ŷ");
		
		list.add(article);
	}
	else
	{
		Iterator iter = list.iterator();
		
		while(iter.hasNext())
		{
		  Article article = (Article)iter.next();
		
		  int size = article.getArticle_comments().size();
		
		  article.setComment_count(size);
		
		  System.out.println("size"+article.getComment_count());
		}
		
		
	}
	
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	request1.put("list", list);
	
	
	
}

/**
 * ͨ��AJAX��ʽ����ҳ����ʾĳһ�û����е�����
 */
 public void ajaxShowAllArticle()throws Exception
 {
	 HttpServletRequest request = ServletActionContext.getRequest();
	 HttpServletResponse response = ServletActionContext.getResponse();
	 
	 int userId = Integer.parseInt(request.getParameter("userId"));
	 
	 System.out.println("�û�ID"+userId);
	 
	 User user2 = this.user_service.findUserById(userId);
	 
	 Set<Article> articleList = (Set)user2.getArticles();
	 
	 List<Article> list1 = new ArrayList<Article>();
		
	 //System.out.println("��������"+articleList.size());
	 
	 Iterator iter = articleList.iterator();
		
		while(iter.hasNext())
		{
			Article article = (Article)iter.next();
			
			Article article1 = new Article();
			
			article1.setArticle_categroy(null);
			article1.setArticle_comments(null);
			article1.setComment_count(article.getComment_count());
			
			//�������ڸ�ʽ�Ĵ�����js���൱�鷳���Խ��������ַ�����ʽ�������������Է������
			
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(article.getDateline());
			
			article1.setContent(date);
			article1.setDateline(null);
			
			article1.setId(article.getId());
			article1.setRead_count(article.getRead_count());
			article1.setTitle(article.getTitle());
			article1.setUser(null);
			
			list1.add(article1);
		}
		
		Gson gson = new Gson();
		
		//System.out.println(list1.size());
		
		
		String result1 = gson.toJson(list1);
		
		System.out.println("���"+result1);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	   
        PrintWriter out = response.getWriter();
		
		out.println(result1);
		
		out.flush();
	 
	 
 }
/**
 * 
 * �����ѯһ���û�����
 * 
 */
public String random()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	User user = (User)session.getAttribute("user");
	
	User visitor = this.user_service.findRandom(1).get(0);
	while(user.getId()== visitor.getId())
	{
		visitor = this.user_service.findRandom(1).get(0);
	}
	

	request.setAttribute("visitor", visitor);

	System.out.println("visitor:Id->"+visitor.getId());
	return "random_success";
}
/**
 * ͨ��AJAX��ʽ���� ���ѵķ��� 
 */

@SuppressWarnings("unchecked")
public void showFriendCategroy()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
	//����Ҫ��ѯ���û�id
	
	User user1 = (User)session.getAttribute("user");
	
	int id = user1.getId();
	
	User user3 = this.user_service.findUserById(id);
	
	System.out.println(user3.getUsername());
	
	Set<Friend_categroy> list = (Set)user3.getFridend_categroys();
	
	List<Friend_categroy> list1 = new ArrayList();
	
	Iterator<Friend_categroy> iter = list.iterator();
	
	System.out.println(list.size());
	
	if(list.size() == 0)
	{
		System.out.println("listΪ�գ�");
		Friend_categroy categroy = new Friend_categroy();
		categroy.setId(0);
		categroy.setFriend_categroy_name("Ĭ�Ϸ���");
	    list1.add(categroy);
	}
	else
	{
		
		
		//�Ի�ö������ת������ֹ���ӳټ���Ӱ��ȡ������
		System.out.println("list��Ϊ�գ�");
		while(iter.hasNext())
		{
			Friend_categroy categroy = (Friend_categroy)iter.next();
			Friend_categroy categroy1 = new Friend_categroy();
			categroy1.setFriend_categroy_name(categroy.getFriend_categroy_name());
			categroy1.setId(categroy.getId());
			list1.add(categroy1);
		}
	}
    
	
	
	Gson gson = new Gson();
	
	//System.out.println(list1.size());
	
	
	String result1 = gson.toJson(list1);
	
	System.out.println("���"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
}

/**
 * ͨ��ҳ������������ʾ���ѷ���
 * @throws Exception
 */
@SuppressWarnings("unused")
public void showFriendCategroy1()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();

	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
	//����Ҫ��ѯ���û�id
	int id = Integer.parseInt(request.getAttribute("id").toString());
	
	User user3 = this.user_service.findUserById(id);
	
	Set<Friend_categroy> list = (Set)user3.getFridend_categroys();
    
	Map request1 = (Map)ActionContext.getContext().get("request");
	
	request1.put("list", list);
}

/**
 * ��ʾĳһ�û������к���(ͨ��ҳ����������)
 */
public void showAllFriend()
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getAttribute("id").toString());
	
	User user = this.user_service.findUserById(id);
	
	Set<Friend> list = user.getFriends();
	List<User> list1 = new ArrayList<User>();
	
	if(list.isEmpty())
	{
		User  user4 = new User();
		user4.setId(0);
		user4.setPassword("�㻹û����Ӻ���Ŷ");
			
		list1.add(user4);
	}
	else
	{
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			Friend friend1 = (Friend)iter.next();
			int i = friend1.getFriender_id();
			User user3 = this.user_service.findUserById(i);
			
			User user4 = new User();
			//���û��д�����������Ϣ������ʹ�û���id����˺��ѹ�ϵ��id
			user4.setId(friend1.getFriender_id());
			user4.setUsername(user3.getUsername());
			user4.setNick_name(user3.getNick_name());
			user4.setBirthday(user3.getBirthday());
			user4.setAddress(user3.getAddress());
			user4.setSelf_introduction(user3.getSelf_introduction());
			if(user3.getAvatar()==null||user3.getAvatar()=="")
			{
				user3.setAvatar("avatar.jpg");
			}
			user4.setAvatar(user3.getAvatar());
			user4.setEmail(user3.getEmail());
			//����ע����    ����   ����ʾ
			user4.setPassword(friend1.getRemark_name());
			//��������ѵ����ڷ���   ����  ��
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(friend1.getAdd_friend_time());
			user4.setQuestion(date);
			//�����ѹ�ϵ��id���ڴ��ֶ���
			String j = friend1.getId()+"";
			user4.setAnswer(j);
			
			list1.add(user4);
		}
	}
	
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	request1.put("list1", list1);

	
}

/**
 * ͨ��ҳ��AJAX��ʽ������ĳһ�û������к���
 */
public void showAjaxFriend()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("id"));
	
	User user = this.user_service.findUserById(id);
	
	Set list = user.getFriends();
	
	List list1 = new ArrayList();
	
	if(list.isEmpty())
	{
		User  user4 = new User();
		user4.setId(0);
		user4.setPassword("�㻹û����Ӻ���Ŷ");
			
		list1.add(user4);
	}
	else
	{
		Iterator iter = list.iterator();
		while(iter.hasNext())
		{
			Friend friend1 = (Friend)iter.next();
			int i = friend1.getFriender_id();
			User user3 = this.user_service.findUserById(i);
			
			User user4 = new User();
			//���û��д�����������Ϣ������ʹ�û���id����˺��ѹ�ϵ��id
			user4.setId(friend1.getFriender_id());
			user4.setUsername(user3.getUsername());
			user4.setNick_name(user3.getNick_name());
			user4.setBirthday(user3.getBirthday());
			user4.setAddress(user3.getAddress());
			user4.setSelf_introduction(user3.getSelf_introduction());
			if(user3.getAvatar()==null||user3.getAvatar()=="")
			{
				user3.setAvatar("avatar.jpg");
			}
			user4.setAvatar(user3.getAvatar());
			user4.setEmail(user3.getEmail());
			//����ע����    ����   ����ʾ
			user4.setPassword(friend1.getRemark_name());
			//��������ѵ����ڷ���   ����  ��
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(friend1.getAdd_friend_time());
			user4.setQuestion(date);
			//�����ѹ�ϵ��id���ڴ��ֶ���
			String j = friend1.getId()+"";
			user4.setAnswer(j);
			
			list1.add(user4);
		}
	}
		
	Gson gson = new Gson();
	
	//System.out.println(list1.size());
	
	
	String result1 = gson.toJson(list1);
	
	System.out.println("���"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
	
}

/**
 * ��ʾ���к��� ҳ����������
 */

public void allUser()throws Exception
{
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	List list = this.user_service.allUser();
	
	Iterator iter = list.iterator();
	
	//List list1 = new ArrayList();
	while(iter.hasNext())
	{
		User user1 = (User)iter.next();
		//������������������
		user1.setPassword(String.valueOf(user1.getArticles().size()));
		//����Ƭ������������
		user1.setQuestion(String.valueOf(user1.getPhotos().size()));
		//�����������ڴ���
		user1.setAnswer(String.valueOf(user1.getFriends().size()));
		
		user1.setAlbums(null);
		user1.setArticle_categroy(null);
		user1.setArticles(null);
		user1.setFridend_categroys(null);
		user1.setFriends(null);
		user1.setMicro_wish(null);
		user1.setPhotos(null);
		
		
	}
	request1.put("list", list);
}
/**
 * ��ʾ���к��ѣ����ʣ���
 */

public void ajaxAllUser()throws Exception
{
	HttpServletResponse response = ServletActionContext.getResponse();
	
    Set list = (Set)this.user_service.allUser();
	
	Iterator iter = list.iterator();
	
	while(iter.hasNext())
	{
		User user1 = (User)iter.next();
		//������������������
		user1.setPassword(String.valueOf(user1.getArticles().size()));
		//����Ƭ������������
		user1.setQuestion(String.valueOf(user1.getPhotos().size()));
		//�����������ڴ���
		user1.setAnswer(String.valueOf(user1.getFriends().size()));
		
		user1.setAlbums(null);
		user1.setArticle_categroy(null);
		user1.setArticles(null);
		user1.setFridend_categroys(null);
		user1.setFriends(null);
		user1.setMicro_wish(null);
		user1.setPhotos(null);
		
	}
	
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
 * ɾ���û�
 */

public void delUser()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("userId"));
	
	this.user_service.removeUser(this.user_service.findUserById(id));
	
	String result = "ɾ���ɹ���";
	
	Gson gson = new Gson();
	
	String result1 = gson.toJson(result);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
    
	PrintWriter out = response.getWriter();
	
	out.println();
}
}
