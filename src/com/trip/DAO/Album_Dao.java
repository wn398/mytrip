package com.trip.DAO;

import java.util.List;

import com.trip.bean.Album;

public interface Album_Dao {
	
   public void removeAlbum(Album album);//�����ݿ�ɾ��ĳ�����
	
	public void savaAlbum(Album album);//�������뵽���ݿ���
	
	public List<Album> allAlbum();//�����ݿ��в�ѯ�����������Ϣ
	
	public Album findAlbumByID(int id);//�������ID��ѯ���
	
	public void updateAlbum(Album album);//������Ƭ��Ϣ


}
