package com.trip.Action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Friend;
import com.trip.bean.Friend_categroy;
import com.trip.bean.User;
import com.trip.service.Friend_categroy_service;
import com.trip.service.User_service;
import com.trip.service.Impl.User_service_Impl;


@SuppressWarnings("serial")
public class Friend_categroy_Action extends ActionSupport {

	private Friend_categroy friend_categroy;
	
	private Friend_categroy_service friend_categroy_service;

	private User_service user_service;

	public User_service getUser_service() {
		return user_service;
	}

	public void setUser_service(User_service userService) {
		user_service = userService;
	}

	public Friend_categroy getFriend_categroy() {
		return friend_categroy;
	}

	public void setFriend_categroy(Friend_categroy friendCategroy) {
		friend_categroy = friendCategroy;
	}

	public Friend_categroy_service getFriend_categroy_service() {
		return friend_categroy_service;
	}

	public void setFriend_categroy_service(
			Friend_categroy_service friendCategroyService) {
		friend_categroy_service = friendCategroyService;
	}

/**
 * 增加好友分类
 */
	public void addCategroy()throws Exception
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpServletRequest request = ServletActionContext.getRequest();
		//HttpSession session = request.getSession();
		//User user = (User)session.getAttribute("user");
		String categroy_name = request.getParameter("name");
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		User user1 = new User();
		user1.setId(userId);
		//设置分类的属性 
		Friend_categroy categroy = new Friend_categroy();
		
		categroy.setFriend_categroy_name(categroy_name);
		categroy.setUser(user1);
		this.friend_categroy_service.saveFriend_categroy(categroy);
		
		Gson gson = new Gson();
		
		//System.out.println(list1.size());
		
		String result = "添加分类成功！";
		String result1 = gson.toJson(result);
		
		System.out.println("结果"+result1);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	   
	    PrintWriter out = response.getWriter();
		
		out.println(result1);
	}
/**
 * 显示一个某一用户分类的好友	 AJAX
 */
@SuppressWarnings("unchecked")
public void showCategroy()throws Exception
{
	HttpServletResponse response = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();
	
	int categroyId = Integer.parseInt(request.getParameter("categroyId"));
	
	Friend_categroy categroy = this.friend_categroy_service.findFriend_categroyById(categroyId);
	
	Set<Friend> list = (Set)categroy.getFriends();
	
     List list1 = new ArrayList();
	System.out.println("长度为："+list.size());
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
			System.out.println("i="+i);
			
			User user3 = this.user_service.findUserById(i);
			
			System.out.println("用户名为："+user3.getUsername());
			User user4 = new User();
			//在用户中储存好友类的信息，方便使用基中id存放了好友关系的id
			user4.setId(friend1.getFriender_id());
			user4.setUsername(user3.getUsername());
			user4.setNick_name(user3.getNick_name());
			user4.setBirthday(user3.getBirthday());
			user4.setAddress(user3.getAddress());
			user4.setSelf_introduction(user3.getSelf_introduction());
			if(user3.getAvatar()==null)
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
}
