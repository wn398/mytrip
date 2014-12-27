package com.trip.service;

import java.util.List;

import com.trip.bean.Photo_comment;

public interface Photo_comment_service {
	
	
	    public void savePhoto_comment(Photo_comment photo_comment);//保存
		
		public void removePhoto_comment(Photo_comment photo_comment);//删除
		
		public List<Photo_comment> allPhoto_comment();//返回所有
		
		public Photo_comment findPhoto_commentById(int id);//查找
		
		public void updatePhoto_comment(Photo_comment photo_comment);//更新

}
