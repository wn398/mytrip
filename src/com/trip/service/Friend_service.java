package com.trip.service;

import java.util.List;

import com.trip.bean.Friend;

public interface Friend_service {
	
	
	   public void saveFriend(Friend friend);//保存
		
		public void removeFriend(Friend friend);//删除
		
		public List<Friend> allFriend();//返回所有
		
		public Friend findFriendById(int id);//查找
		
		public void updateFriend(Friend friend);//更新

}
