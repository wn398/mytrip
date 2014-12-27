package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Wish_comment_Dao;
import com.trip.bean.Wish_comment;
import com.trip.service.Wish_comment_service;

public class Wish_comment_service_Impl implements Wish_comment_service {
	
	
	   private Wish_comment_Dao  wish_comment_dao;
		
		
		public Wish_comment_Dao getWish_comment_dao() {
			return wish_comment_dao;
		}

		public void setWish_comment_dao(Wish_comment_Dao wish_comment_Dao) {
			wish_comment_dao = wish_comment_Dao;
		}

		  
		
		
		public void removeWish_comment(Wish_comment wish_comment) {
			this.wish_comment_dao.removeWish_comment(wish_comment);

		}

		public void saveWish_comment(Wish_comment wish_comment) {
			this.wish_comment_dao.savaWish_comment(wish_comment);

		}

		 public List<Wish_comment> allWish_comment() {
		
			return this.wish_comment_dao.allWish_comment();
			
			
		}

		public Wish_comment findWish_commentById(int id) {
			return this.wish_comment_dao.findWish_commentByID(id);
		}

		
		public void updateWish_comment(Wish_comment wish_comment) {
			this.wish_comment_dao.updateWish_comment(wish_comment);
		}
	
	
	

}
