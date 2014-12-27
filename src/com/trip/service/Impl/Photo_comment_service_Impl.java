package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Photo_comment_Dao;
import com.trip.bean.Photo_comment;
import com.trip.service.Photo_comment_service;

public class Photo_comment_service_Impl implements Photo_comment_service {
	
	
	
	 private Photo_comment_Dao  photo_comment_dao;
		
		
		public Photo_comment_Dao getPhoto_comment_dao() {
			return photo_comment_dao;
		}

		public void setPhoto_comment_dao(Photo_comment_Dao photo_comment_Dao) {
			photo_comment_dao = photo_comment_Dao;
		}

		public void removePhoto_comment(Photo_comment photo_comment) {
			this.photo_comment_dao.removePhoto_comment(photo_comment);

		}

		public void savePhoto_comment(Photo_comment photo_comment) {
			this.photo_comment_dao.savaPhoto_comment(photo_comment);

		}

		 public List<Photo_comment> allPhoto_comment() {
		
			return this.photo_comment_dao.allPhoto_comment();
			
			
		}

		public Photo_comment findPhoto_commentById(int id) {
			return this.photo_comment_dao.findPhoto_commentByID(id);
		}

		
		public void updatePhoto_comment(Photo_comment photo_comment) {
			this.photo_comment_dao.updatePhoto_comment(photo_comment);
		}

}
