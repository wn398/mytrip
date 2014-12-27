package com.trip.DAO;

import java.util.List;

import com.trip.bean.Photo;

public interface Photo_Dao {
	
   public void removePhoto(Photo photo);//从数据库删除某个相片
	
	public void savaPhoto(Photo photo);//将相片存入到数据库中
	
	public List<Photo> allPhoto();//从数据库中查询出所有相片信息
	
	public Photo findPhotoByID(int id);//按照相片ID查询相片
	
	public void updatePhoto(Photo photo);//更新相片信息

}
