package com.trip.bean;

import java.util.Date;
import java.util.Set;
/**
 * 
 * Î¢ÐÄÔ¸
 *
 */
@SuppressWarnings("unchecked")
public class Micro_wish {
	private int id;
	
	private String wish_content;
	
	private Date add_wish_time;
	
	private User user;
	
	
	private Set wish_comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWish_content() {
		return wish_content;
	}

	public void setWish_content(String wishContent) {
		wish_content = wishContent;
	}

	public Date getAdd_wish_time() {
		return add_wish_time;
	}

	public void setAdd_wish_time(Date addWishTime) {
		add_wish_time = addWishTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getWish_comment() {
		return wish_comment;
	}

	public void setWish_comment(Set wishComment) {
		wish_comment = wishComment;
	}

}
