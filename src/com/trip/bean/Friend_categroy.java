package com.trip.bean;

import java.util.Set;

@SuppressWarnings("unchecked")
public class Friend_categroy {
	private int id;
	
	private String friend_categroy_name;

	private User user;
	
	
	private Set friends;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFriend_categroy_name() {
		return friend_categroy_name;
	}

	public void setFriend_categroy_name(String friendCategroyName) {
		friend_categroy_name = friendCategroyName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getFriends() {
		return friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}
}
