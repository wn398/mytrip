package com.trip.DAO;

import java.util.List;

import com.trip.bean.Photo;

public interface Photo_Dao {
	
   public void removePhoto(Photo photo);//�����ݿ�ɾ��ĳ����Ƭ
	
	public void savaPhoto(Photo photo);//����Ƭ���뵽���ݿ���
	
	public List<Photo> allPhoto();//�����ݿ��в�ѯ��������Ƭ��Ϣ
	
	public Photo findPhotoByID(int id);//������ƬID��ѯ��Ƭ
	
	public void updatePhoto(Photo photo);//������Ƭ��Ϣ

}
