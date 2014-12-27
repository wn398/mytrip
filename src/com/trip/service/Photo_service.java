package com.trip.service;

import java.util.List;

import com.trip.bean.Photo;

public interface Photo_service {
	
	
	 public void savePhoto(Photo photo);//保存
		
		public void removePhoto(Photo photo);//删除
		
		public List<Photo> allPhoto();//返回所有
		
		public Photo findPhotoById(int id);//查找
		
		public void updatePhoto(Photo photo);//更新

}
