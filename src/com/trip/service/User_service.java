package com.trip.service;

import java.util.List;

import com.trip.bean.User;

public interface User_service {
	
	
	    public void saveUser(User user);//保存
		
		public void removeUser(User user);//删除
		
		public List<User> allUser();//返回所有
		
		public User findUserById(int id);//查找
		
		public void updateUser(User user);//更新
		
		public List<User> findUserByName(String username);//根据用户名查询用户
		
		public List<User> findRandom(int i);//随机查询几个用户

}
