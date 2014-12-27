package com.trip.DAO;

import java.util.List;

import com.trip.bean.Friend_categroy;

public interface Friend_categroy_Dao {
	
    public void removeFriend_categroy(Friend_categroy friend_categroy);//从数据库删除某个好友分类
	
	public void savaFriend_categroy(Friend_categroy friend_categroy);//将好友分类存入到数据库中
	
	public List<Friend_categroy> allFriend_categroy();//从数据库中查询出所有好友分类信息
	
	public Friend_categroy findFriend_categroyByID(int id);//按照好友分类ID查询好友分类
	
	public void updateFriend_categroy(Friend_categroy friend_categroy);//更新好友分类信息


}
