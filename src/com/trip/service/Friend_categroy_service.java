package com.trip.service;

import java.util.List;

import com.trip.bean.Friend_categroy;

public interface Friend_categroy_service {
	
	
	 public void saveFriend_categroy(Friend_categroy friend_categroy);//����
		
		public void removeFriend_categroy(Friend_categroy friend_categroy);//ɾ��
		
		public List<Friend_categroy> allFriend_categroy();//��������
		
		public Friend_categroy findFriend_categroyById(int id);//����
		
		public void updateFriend_categroy(Friend_categroy friend_categroy);//����

}
