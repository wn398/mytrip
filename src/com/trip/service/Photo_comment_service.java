package com.trip.service;

import java.util.List;

import com.trip.bean.Photo_comment;

public interface Photo_comment_service {
	
	
	    public void savePhoto_comment(Photo_comment photo_comment);//����
		
		public void removePhoto_comment(Photo_comment photo_comment);//ɾ��
		
		public List<Photo_comment> allPhoto_comment();//��������
		
		public Photo_comment findPhoto_commentById(int id);//����
		
		public void updatePhoto_comment(Photo_comment photo_comment);//����

}
