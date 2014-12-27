package com.trip.service;

import java.util.List;

import com.trip.bean.Friend_categroy;

public interface Friend_categroy_service {
	
	
	 public void saveFriend_categroy(Friend_categroy friend_categroy);//保存
		
		public void removeFriend_categroy(Friend_categroy friend_categroy);//删除
		
		public List<Friend_categroy> allFriend_categroy();//返回所有
		
		public Friend_categroy findFriend_categroyById(int id);//查找
		
		public void updateFriend_categroy(Friend_categroy friend_categroy);//更新

}
