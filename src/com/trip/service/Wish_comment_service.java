package com.trip.service;

import java.util.List;

import com.trip.bean.Wish_comment;


public interface Wish_comment_service {
	
    public void saveWish_comment(Wish_comment wish_comment);//����
	
	public void removeWish_comment(Wish_comment wish_comment);//ɾ��
	
	public List<Wish_comment> allWish_comment();//��������
	
	public Wish_comment findWish_commentById(int id);//����
	
	public void updateWish_comment(Wish_comment wish_comment);//����


}
