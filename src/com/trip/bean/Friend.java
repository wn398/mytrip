package com.trip.bean;

import java.util.Date;

public class Friend {
	private int id;
	
	private int friender_id;
	
	private String remark_name;
	
	private Date add_friend_time;
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Friend_categroy getFriend_categroy() {
		return friend_categroy;
	}

	public void setFriend_categroy(Friend_categroy friendCategroy) {
		friend_categroy = friendCategroy;
	}

	private Friend_categroy friend_categroy;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public int getFriender_id() {
		return friender_id;
	}

	public void setFriender_id(int frienderId) {
		friender_id = frienderId;
	}

	public String getRemark_name() {
		return remark_name;
	}

	public void setRemark_name(String remarkName) {
		remark_name = remarkName;
	}

	public Date getAdd_friend_time() {
		return add_friend_time;
	}

	public void setAdd_friend_time(Date addFriendTime) {
		add_friend_time = addFriendTime;
	}

	
}
