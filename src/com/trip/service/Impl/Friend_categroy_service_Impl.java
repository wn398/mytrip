package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Friend_categroy_Dao;
import com.trip.bean.Friend_categroy;
import com.trip.service.Friend_categroy_service;

public class Friend_categroy_service_Impl implements Friend_categroy_service {
	
	
	 private Friend_categroy_Dao  friend_categroy_dao;
		
		
		public Friend_categroy_Dao getFriend_categroy_dao() {
			return friend_categroy_dao;
		}

		public void setFriend_categroy_dao(Friend_categroy_Dao friend_categroy_Dao) {
			friend_categroy_dao = friend_categroy_Dao;
		}

		public void removeFriend_categroy(Friend_categroy friend_categroy) {
			this.friend_categroy_dao.removeFriend_categroy(friend_categroy);

		}

		public void saveFriend_categroy(Friend_categroy friend_categroy) {
			this.friend_categroy_dao.savaFriend_categroy(friend_categroy);

		}

		 public List<Friend_categroy> allFriend_categroy() {
		
			return this.friend_categroy_dao.allFriend_categroy();
			
			
		}

		public Friend_categroy findFriend_categroyById(int id) {
			return this.friend_categroy_dao.findFriend_categroyByID(id);
		}

		
		public void updateFriend_categroy(Friend_categroy friend_categroy) {
			this.friend_categroy_dao.updateFriend_categroy(friend_categroy);
		}

}
