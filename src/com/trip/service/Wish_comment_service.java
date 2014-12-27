package com.trip.service;

import java.util.List;

import com.trip.bean.Wish_comment;


public interface Wish_comment_service {
	
    public void saveWish_comment(Wish_comment wish_comment);//保存
	
	public void removeWish_comment(Wish_comment wish_comment);//删除
	
	public List<Wish_comment> allWish_comment();//返回所有
	
	public Wish_comment findWish_commentById(int id);//查找
	
	public void updateWish_comment(Wish_comment wish_comment);//更新


}
