package com.trip.service;

import java.util.List;

import com.trip.bean.Friend;

public interface Friend_service {
	
	
	   public void saveFriend(Friend friend);//����
		
		public void removeFriend(Friend friend);//ɾ��
		
		public List<Friend> allFriend();//��������
		
		public Friend findFriendById(int id);//����
		
		public void updateFriend(Friend friend);//����

}
