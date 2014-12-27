package com.trip.DAO;

import java.util.List;

import com.trip.bean.Wish_comment;

public interface Wish_comment_Dao {
	
   public void removeWish_comment(Wish_comment wish_comment);//从数据库删除某个心愿评论
	
	public void savaWish_comment(Wish_comment wish_comment);//将心愿评论存入到数据库中
	
	public List<Wish_comment> allWish_comment();//从数据库中查询出所有心愿评论信息
	
	public Wish_comment findWish_commentByID(int id);//按照心愿评论ID查询心愿评论
	
	public void updateWish_comment(Wish_comment wish_comment);//更新心愿评论信息


}
