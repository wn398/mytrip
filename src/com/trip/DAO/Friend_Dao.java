package com.trip.DAO;

import java.util.List;

import com.trip.bean.Friend;

public interface Friend_Dao {
	
   public void removeFriend(Friend friend);//从数据库删除某个好友
	
	public void savaFriend(Friend friend);//将好友存入到数据库中
	
	public List<Friend> allFriend();//从数据库中查询出所有好友信息
	
	public Friend findFriendByID(int id);//按照好友ID查询好友
	
	public void updateFriend(Friend friend);//更新好友信息


}
