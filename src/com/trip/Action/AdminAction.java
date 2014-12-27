package com.trip.Action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
  
	private String username;
  
	private String password;
		
	   public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	 @Override
	public String execute() throws Exception {
		 
		 System.out.println(username);
		 System.out.println(password);
		if(username.equals("admin")& password.equals("123456"))
		{
			
			return SUCCESS;
		}
		else
		{
			this.addActionError("用户名或密码输入错误！");
			return INPUT;
		}
		
	}
}
