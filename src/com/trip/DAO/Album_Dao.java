package com.trip.DAO;

import java.util.List;

import com.trip.bean.Album;

public interface Album_Dao {
	
   public void removeAlbum(Album album);//从数据库删除某个相册
	
	public void savaAlbum(Album album);//将相册存入到数据库中
	
	public List<Album> allAlbum();//从数据库中查询出所有相册信息
	
	public Album findAlbumByID(int id);//按照相册ID查询相册
	
	public void updateAlbum(Album album);//更新相片信息


}
