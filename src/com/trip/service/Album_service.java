package com.trip.service;

import java.util.List;

import com.trip.bean.Album;

public interface Album_service {
	
	
	    public void saveAlbum(Album album);//保存
		
		public void removeAlbum(Album album);//删除
		
		public List<Album> allAlbum();//返回所有
		
		public Album findAlbumById(int id);//查找
		
		public void updateAlbum(Album album);//更新

}
