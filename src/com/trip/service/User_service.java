package com.trip.service;

import java.util.List;

import com.trip.bean.User;

public interface User_service {
	
	
	    public void saveUser(User user);//����
		
		public void removeUser(User user);//ɾ��
		
		public List<User> allUser();//��������
		
		public User findUserById(int id);//����
		
		public void updateUser(User user);//����
		
		public List<User> findUserByName(String username);//�����û�����ѯ�û�
		
		public List<User> findRandom(int i);//�����ѯ�����û�

}
