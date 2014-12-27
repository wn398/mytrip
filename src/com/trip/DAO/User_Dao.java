package com.trip.DAO;

import java.util.List;

import com.trip.bean.User;


public interface User_Dao {
	
	public void removeUser(User user);//从数据库删除某个用户
	
	public void savaUser(User user);//将用户存入到数据库中
	
	public List<User> allUser();//从数据库中查询出所有用户信息
	
	public User findUserByID(int id);//按照用户ID查询用户
	
	public void updateUser(User user);//更新用户信息
	
	public List<User> findUserByName(String username);//根据用户名查询用户
	
	public List<User> findRandom(int i);//随机查询一个用户

}
