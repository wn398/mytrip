package com.trip.service.Impl;

import java.util.List;


import com.trip.DAO.User_Dao;
import com.trip.bean.User;
import com.trip.service.User_service;

public class User_service_Impl implements User_service {
	
	
    private User_Dao  user_dao;
	
	
	public User_Dao getUser_dao() 
	{
		return user_dao;
	}

	public void setUser_dao(User_Dao user_Dao) 
	{
		user_dao = user_Dao;
	}

	public void removeUser(User user) 
	{
		this.user_dao.removeUser(user);

	}

	public void saveUser(User user) 
	{
		this.user_dao.savaUser(user);

	}

	 public List<User> allUser() 
	 {
	
		return this.user_dao.allUser();
		
		
	}

	public User findUserById(int id) 
	{
		return this.user_dao.findUserByID(id);
	}

	
	public void updateUser(User user) 
	{
		this.user_dao.updateUser(user);
	}

	public List<User> findUserByName(String username) 
	{
		return this.user_dao.findUserByName(username);
	}

	public List<User> findRandom(int i)
	{
		return this.user_dao.findRandom(i);
		
	}

	

}
