package com.trip.DAO;

import java.util.List;

import com.trip.bean.Photo_comment;

public interface Photo_comment_Dao {
    
	public void removePhoto_comment(Photo_comment photo);//�����ݿ�ɾ��ĳ����Ƭ����
	
	public void savaPhoto_comment(Photo_comment photo);//����Ƭ���۴��뵽���ݿ���
	
	public List<Photo_comment> allPhoto_comment();//�����ݿ��в�ѯ��������Ƭ������Ϣ
	
	public Photo_comment findPhoto_commentByID(int id);//������Ƭ����ID��ѯ��Ƭ����
	
	public void updatePhoto_comment(Photo_comment photo_comment);//������Ƭ������Ϣ

	

}
