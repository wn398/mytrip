package com.trip.service;

import java.util.List;

import com.trip.bean.Album;

public interface Album_service {
	
	
	    public void saveAlbum(Album album);//����
		
		public void removeAlbum(Album album);//ɾ��
		
		public List<Album> allAlbum();//��������
		
		public Album findAlbumById(int id);//����
		
		public void updateAlbum(Album album);//����

}
