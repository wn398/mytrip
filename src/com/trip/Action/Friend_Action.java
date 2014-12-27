package com.trip.Action;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.trip.bean.Friend;
import com.trip.bean.Friend_categroy;
import com.trip.bean.User;
import com.trip.service.Friend_service;

@SuppressWarnings("serial")
public class Friend_Action extends ActionSupport {

	private Friend friend;
	
	private Friend_service friend_service;

	public Friend getFriend() {
		return friend;
	}

	public void setFriend(Friend friend) {
		this.friend = friend;
	}

	public Friend_service getFriend_service() {
		return friend_service;
	}

	public void setFriend_service(Friend_service friendService) {
		friend_service = friendService;
	}
/**
 * ���Ӻ���	
 */
	public void addFriend()throws  Exception
	{
      HttpServletRequest request = ServletActionContext.getRequest();
      HttpSession session = request.getSession();
      HttpServletResponse response = ServletActionContext.getResponse();
      
      User user = (User)session.getAttribute("user");
      
      //��ú��ѵ�id
      int friender_id = Integer.parseInt(request.getParameter("visitorId"));
      //��ú��ѷ����id
      System.out.println("visitorId:"+friender_id);
      
      int frienderCategroy_id = Integer.parseInt(request.getParameter("friendCategroy_id"));
      
      System.out.println("frienderCategroy_id:"+frienderCategroy_id);
      Friend friend1 = new Friend();
      //���ʹ�õ���Ĭ�Ϸ��࣬����ִ��������δ��룬����ӷ���
      if(frienderCategroy_id!=0)
      {
      Friend_categroy friendCategroy = new Friend_categroy();
      
      friendCategroy.setId(frienderCategroy_id);
      
      friend1.setFriend_categroy(friendCategroy);
      }
      
      
      friend1.setFriender_id(friender_id);
      friend1.setUser(user);
      friend1.setAdd_friend_time(new Date());
      
      this.friend_service.saveFriend(friend1);
       
      Gson gson = new Gson();
		
		//System.out.println(list1.size());
		
		String result = "��Ӻ��ѳɹ���";
		String result1 = gson.toJson(result);
		
		System.out.println("���"+result1);
		
		response.setContentType("application/json; charset=utf-8");
	    response.setHeader("pragma", "no-cache");
	    response.setHeader("cache-control", "no-cache");
	   
        PrintWriter out = response.getWriter();
		
		out.println(result1);
		
		out.flush();
      
      
		
		
		
	}
	
/**
 * ���º��ѱ�ע	AJAX
 */

public void updateNick_name()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	//int id = Integer.parseInt(request.getParameter("friendId"));
	
	//String name = request.getParameter("name");
	
	//System.out.println(name);
	
	Friend friend1 = this.friend_service.findFriendById(friend.getId());
	
	friend1.setRemark_name(friend.getRemark_name());
	
	this.friend_service.updateFriend(friend1);
	
	Gson gson = new Gson();
	
	//System.out.println(list1.size());
	
	String result = "���±�ע�ɹ���";
	String result1 = gson.toJson(result);
	
	System.out.println("���"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
	
}
/**
 * ɾ������	AJAX
 */

public void deleteFriend()throws Exception
{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	
	int id = Integer.parseInt(request.getParameter("friendId"));
	
	
	
	Friend friend1 = this.friend_service.findFriendById(id);
	
	
	
	this.friend_service.removeFriend(friend1);
	
	Gson gson = new Gson();
	
	//System.out.println(list1.size());
	
	String result = "ɾ�����ѳɹ���";
	String result1 = gson.toJson(result);
	
	System.out.println("���"+result1);
	
	response.setContentType("application/json; charset=utf-8");
    response.setHeader("pragma", "no-cache");
    response.setHeader("cache-control", "no-cache");
   
    PrintWriter out = response.getWriter();
	
	out.println(result1);
	
	out.flush();
}
}
