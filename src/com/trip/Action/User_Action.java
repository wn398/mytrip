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
	 * 导入实体user与 服务层的User_service
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
	 * 以下为上传文件准备的三个属性
	 */
    private File file;
	
    private String fileFileName;
	
	private String fileContentType;
	
/**
 * 以下为自定义方法
 */
/**
 * 注册Action	
 */
	public String registerAction()throws Exception{
		
		user.setRegister_time(new Date());
		
		this.user_service.saveUser(user);
		
		return "register_success";
	}
/**
 * 
 * registerAction的校验方法
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
			this.addActionError("用户名不能为空");
		}
		
		if(!(this.user_service.findUserByName(username).isEmpty()))
		{
			this.addActionError("该用户名已经注册");
			return ;
		}
		
		if("".equals(password)||null==password)
		{
			this.addActionError("密码不能为空");
		}
		if(!password.equals(repassword))
		{
			this.addActionError("密码不一致！");
		}
		if("".equals(question)||null==question)
		{
			this.addActionError("密码问题不能为空！");
		}
		if("".equals(answer)||null==answer)
		{
			this.addActionError("密码答案不能为空");
		}
		//验证校验码
		if(!ValidationCode.checkValidationCode(request, validationCode))
		{
			this.addActionError("校验码输入错误");
			System.out.println(validationCode);
			return ;
		}
		
	}
/**
 * 登陆Action
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
			this.addActionError("不存在的用户名，请注册！");
			return "load_failure";
		}
		for(int i=0;i<list.size();i++)
		{
			User user=(User)list.get(i);
			if(user.getUsername().equals(username)&&user.getPassword().equals(password))
			{
				//将用户信息放入session中
				ActionContext.getContext().getSession().put("user", user);
				
				
			}
			else
			{
			  this.addActionError("密码错误请重新输入！");
			  return "load_failure";	
			}
		}
		return "load_success";
	}
/**
 * 更新个人信息Action	
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
 * 上传头像的Action
 */
	@SuppressWarnings("deprecation")
	
	public String updateAavatarAction() throws Exception{
       
		//从session中获得user对象
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
			
			//将图片名存入数据库			
			User user2=this.user_service.findUserById(id);
			
			user2.setAvatar(rename+type);
			
			this.user_service.updateUser(user2);
			
			//更新session中的user;
			ActionContext.getContext().getSession().put("user", user2);
		
	     	return "updateAvatar_success";
	
	}
/**
 * 寻找密码的Action
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
				String[] result = {"不存在的用户名！！！"};
				
				Gson gson = new Gson();
				//System.out.println(user3.getUsername());
				String result1 = gson.toJson(result);
				
				//String result = user3.getQuestion();
				//设置向页面的传输方式与缓存设置
		        
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
			//设置向页面的传输方式与缓存设置
	        
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
				String[] result = {"你的密码答案不正确，请想一想"};
				
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
 * 	显示我的相册分类
 */
@SuppressWarnings("unchecked")
public String showMyAlbum()throws Exception{
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		//User user = (User)session.getAttribute("user");
		//int id = user.getId();
		
		//将从请求中获得的id转换成整型
		int id = Integer.parseInt(request.getAttribute("userId").toString());
		
		User user1 = this.user_service.findUserById(id);
		
		Set<Album> list = (Set)user1.getAlbums();
		/*
		if(list.isEmpty())
		{
			Album album = new Album();
			album.setId(0);
			album.setAlbum_name("默认相册");
			album.setAlbum_introduction("默认相册");
			
			list.add(album);
		}
		*/
		
		Map request1 = (Map) ActionContext.getContext().get("request");
		
		request1.put("list", list);
		
		return "showMyAlbum_success";
	}


/**
 *显示文章的分类 
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
		article_categroy.setCategroy_name("默认分类");
		
		
		list.add(article_categroy);
	}
	
	
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	request1.put("list", list);
	
	//System.out.println(list.size());
	
	
	
	return "showArticleCategroy_success";
	
}
/**
 * 显示该用户的所有文章通过页面正常请求
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
		article.setTitle("没有文章");
		article.setComment_count(0);
		article.setContent("你还没有添加文章哦");
		
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
 * 通过AJAX方式请求页面显示某一用户所有的文章
 */
 public void ajaxShowAllArticle()throws Exception
 {
	 HttpServletRequest request = ServletActionContext.getRequest();
	 HttpServletResponse response = ServletActionContext.getResponse();
	 
	 int userId = Integer.parseInt(request.getParameter("userId"));
	 
	 System.out.println("用户ID"+userId);
	 
	 User user2 = this.user_service.findUserById(userId);
	 
	 Set<Article> articleList = (Set)user2.getArticles();
	 
	 List<Article> list1 = new ArrayList<Article>();
		
	 //System.out.println("文章数："+articleList.size());
	 
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
			
			list1.add(article1);
		}
		
		Gson gson = new Gson();
		
		//System.out.println(list1.size());
		
		
		String result1 = gson.toJson(list1);
		
		System.out.println("结果"+result1);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	   
        PrintWriter out = response.getWriter();
		
		out.println(result1);
		
		out.flush();
	 
	 
 }
/**
 * 
 * 随机查询一个用户出来
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
 * 通过AJAX方式请求 好友的分类 
 */

@SuppressWarnings("unchecked")
public void showFriendCategroy()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
	//传入要查询的用户id
	
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
		System.out.println("list为空！");
		Friend_categroy categroy = new Friend_categroy();
		categroy.setId(0);
		categroy.setFriend_categroy_name("默认分类");
	    list1.add(categroy);
	}
	else
	{
		
		
		//对获得对象进行转化，防止有延迟加载影响取得数据
		System.out.println("list不为空！");
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
	
	System.out.println("结果"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
}

/**
 * 通过页面正常请求显示好友分类
 * @throws Exception
 */
@SuppressWarnings("unused")
public void showFriendCategroy1()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();

	HttpSession session = request.getSession();
	HttpServletResponse response = ServletActionContext.getResponse();
	//传入要查询的用户id
	int id = Integer.parseInt(request.getAttribute("id").toString());
	
	User user3 = this.user_service.findUserById(id);
	
	Set<Friend_categroy> list = (Set)user3.getFridend_categroys();
    
	Map request1 = (Map)ActionContext.getContext().get("request");
	
	request1.put("list", list);
}

/**
 * 显示某一用户的所有好友(通过页面正常请求)
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
		user4.setPassword("你还没有添加好友哦");
			
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
			//在用户中储存好友类的信息，方便使用基中id存放了好友关系的id
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
			//将备注放在    密码   中显示
			user4.setPassword(friend1.getRemark_name());
			//将添加朋友的日期放在   问题  中
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(friend1.getAdd_friend_time());
			user4.setQuestion(date);
			//将好友关系的id放在答案字段中
			String j = friend1.getId()+"";
			user4.setAnswer(j);
			
			list1.add(user4);
		}
	}
	
	Map request1 = (Map) ActionContext.getContext().get("request");
	
	request1.put("list1", list1);

	
}

/**
 * 通过页面AJAX方式请求获得某一用户的所有好友
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
		user4.setPassword("你还没有添加好友哦");
			
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
			//在用户中储存好友类的信息，方便使用基中id存放了好友关系的id
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
			//将备注放在    密码   中显示
			user4.setPassword(friend1.getRemark_name());
			//将添加朋友的日期放在   问题  中
			SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String date = formater.format(friend1.getAdd_friend_time());
			user4.setQuestion(date);
			//将好友关系的id放在答案字段中
			String j = friend1.getId()+"";
			user4.setAnswer(j);
			
			list1.add(user4);
		}
	}
		
	Gson gson = new Gson();
	
	//System.out.println(list1.size());
	
	
	String result1 = gson.toJson(list1);
	
	System.out.println("结果"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
	
}

/**
 * 显示所有好友 页面正常请求
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
		//将文章数放在密码中
		user1.setPassword(String.valueOf(user1.getArticles().size()));
		//将相片数放在问题中
		user1.setQuestion(String.valueOf(user1.getPhotos().size()));
		//将好友数放在答案中
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
 * 显示所有好友，ＡＪＡＸ
 */

public void ajaxAllUser()throws Exception
{
	HttpServletResponse response = ServletActionContext.getResponse();
	
    Set list = (Set)this.user_service.allUser();
	
	Iterator iter = list.iterator();
	
	while(iter.hasNext())
	{
		User user1 = (User)iter.next();
		//将文章数放在密码中
		user1.setPassword(String.valueOf(user1.getArticles().size()));
		//将相片数放在问题中
		user1.setQuestion(String.valueOf(user1.getPhotos().size()));
		//将好友数放在答案中
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
 * 删除用户
 */

public void delUser()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("userId"));
	
	this.user_service.removeUser(this.user_service.findUserById(id));
	
	String result = "删除成功！";
	
	Gson gson = new Gson();
	
	String result1 = gson.toJson(result);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
    
	PrintWriter out = response.getWriter();
	
	out.println();
}
}
