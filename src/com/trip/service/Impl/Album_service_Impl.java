package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Album_Dao;
import com.trip.bean.Album;
import com.trip.service.Album_service;

public class Album_service_Impl implements Album_service {
	
	
	 private Album_Dao  album_dao;
		
		
		public Album_Dao getAlbum_dao() {
			return album_dao;
		}

		public void setAlbum_dao(Album_Dao album_Dao) {
			album_dao = album_Dao;
		}

		public void removeAlbum(Album album) {
			this.album_dao.removeAlbum(album);

		}

		public void saveAlbum(Album album) {
			this.album_dao.savaAlbum(album);

		}

		 public List<Album> allAlbum() {
		
			return this.album_dao.allAlbum();
			
			
		}

		public Album findAlbumById(int id) {
			return this.album_dao.findAlbumByID(id);
		}

		
		public void updateAlbum(Album album) {
			this.album_dao.updateAlbum(album);
		}

}
