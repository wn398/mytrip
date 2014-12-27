package com.trip.DAO;

import java.util.List;

import com.trip.bean.Photo_comment;

public interface Photo_comment_Dao {
    
	public void removePhoto_comment(Photo_comment photo);//从数据库删除某个相片评论
	
	public void savaPhoto_comment(Photo_comment photo);//将相片评论存入到数据库中
	
	public List<Photo_comment> allPhoto_comment();//从数据库中查询出所有相片评论信息
	
	public Photo_comment findPhoto_commentByID(int id);//按照相片评论ID查询相片评论
	
	public void updatePhoto_comment(Photo_comment photo_comment);//更新相片评论信息

	

}
