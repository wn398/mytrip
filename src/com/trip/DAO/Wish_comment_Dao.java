package com.trip.DAO;

import java.util.List;

import com.trip.bean.Wish_comment;

public interface Wish_comment_Dao {
	
   public void removeWish_comment(Wish_comment wish_comment);//�����ݿ�ɾ��ĳ����Ը����
	
	public void savaWish_comment(Wish_comment wish_comment);//����Ը���۴��뵽���ݿ���
	
	public List<Wish_comment> allWish_comment();//�����ݿ��в�ѯ��������Ը������Ϣ
	
	public Wish_comment findWish_commentByID(int id);//������Ը����ID��ѯ��Ը����
	
	public void updateWish_comment(Wish_comment wish_comment);//������Ը������Ϣ


}
