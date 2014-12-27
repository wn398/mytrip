package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Friend_Dao;
import com.trip.bean.Friend;
import com.trip.service.Friend_service;

public class Friend_service_Impl implements Friend_service {

	    private Friend_Dao  friend_dao;
		
		
		public Friend_Dao getFriend_dao() {
			return friend_dao;
		}

		public void setFriend_dao(Friend_Dao friend_Dao) {
			friend_dao = friend_Dao;
		}

		public void removeFriend(Friend friend) {
			this.friend_dao.removeFriend(friend);

		}

		public void saveFriend(Friend friend) {
			this.friend_dao.savaFriend(friend);

		}

		 public List<Friend> allFriend() {
		
			return this.friend_dao.allFriend();
			
			
		}

		public Friend findFriendById(int id) {
			return this.friend_dao.findFriendByID(id);
		}

		
		public void updateFriend(Friend friend) {
			this.friend_dao.updateFriend(friend);
		}
}
