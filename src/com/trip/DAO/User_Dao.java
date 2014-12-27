package com.trip.DAO;

import java.util.List;

import com.trip.bean.User;


public interface User_Dao {
	
	public void removeUser(User user);//�����ݿ�ɾ��ĳ���û�
	
	public void savaUser(User user);//���û����뵽���ݿ���
	
	public List<User> allUser();//�����ݿ��в�ѯ�������û���Ϣ
	
	public User findUserByID(int id);//�����û�ID��ѯ�û�
	
	public void updateUser(User user);//�����û���Ϣ
	
	public List<User> findUserByName(String username);//�����û�����ѯ�û�
	
	public List<User> findRandom(int i);//�����ѯһ���û�

}
