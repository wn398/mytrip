package com.trip.DAO;

import java.util.List;

import com.trip.bean.Friend_categroy;

public interface Friend_categroy_Dao {
	
    public void removeFriend_categroy(Friend_categroy friend_categroy);//�����ݿ�ɾ��ĳ�����ѷ���
	
	public void savaFriend_categroy(Friend_categroy friend_categroy);//�����ѷ�����뵽���ݿ���
	
	public List<Friend_categroy> allFriend_categroy();//�����ݿ��в�ѯ�����к��ѷ�����Ϣ
	
	public Friend_categroy findFriend_categroyByID(int id);//���պ��ѷ���ID��ѯ���ѷ���
	
	public void updateFriend_categroy(Friend_categroy friend_categroy);//���º��ѷ�����Ϣ


}
