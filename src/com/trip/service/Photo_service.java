package com.trip.service;

import java.util.List;

import com.trip.bean.Photo;

public interface Photo_service {
	
	
	 public void savePhoto(Photo photo);//����
		
		public void removePhoto(Photo photo);//ɾ��
		
		public List<Photo> allPhoto();//��������
		
		public Photo findPhotoById(int id);//����
		
		public void updatePhoto(Photo photo);//����

}
