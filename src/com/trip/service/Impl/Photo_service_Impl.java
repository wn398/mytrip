package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Photo_Dao;
import com.trip.bean.Photo;
import com.trip.service.Photo_service;

public class Photo_service_Impl implements Photo_service {
	
	
	   private Photo_Dao  photo_dao;
		
		
		public Photo_Dao getPhoto_dao() {
			return photo_dao;
		}

		public void setPhoto_dao(Photo_Dao photo_Dao) {
			photo_dao = photo_Dao;
		}

		public void removePhoto(Photo photo) {
			this.photo_dao.removePhoto(photo);

		}

		public void savePhoto(Photo photo) {
			this.photo_dao.savaPhoto(photo);

		}

		 public List<Photo> allPhoto() {
		
			return this.photo_dao.allPhoto();
			
			
		}

		public Photo findPhotoById(int id) {
			return this.photo_dao.findPhotoByID(id);
		}

		
		public void updatePhoto(Photo photo) {
			this.photo_dao.updatePhoto(photo);
		}

}
