package com.trip.DAO;

import java.util.List;

import com.trip.bean.Friend;

public interface Friend_Dao {
	
   public void removeFriend(Friend friend);//�����ݿ�ɾ��ĳ������
	
	public void savaFriend(Friend friend);//�����Ѵ��뵽���ݿ���
	
	public List<Friend> allFriend();//�����ݿ��в�ѯ�����к�����Ϣ
	
	public Friend findFriendByID(int id);//���պ���ID��ѯ����
	
	public void updateFriend(Friend friend);//���º�����Ϣ


}
