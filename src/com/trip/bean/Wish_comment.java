package com.trip.bean;

import java.util.Date;
/**
 * 
 * ÐÄÔ¸ÆÀÂÛ
 *
 */
public class Wish_comment {
	private int id;
	
	private String wish_comment_content;
    
	private Date wish_comment_time;
	
	private int wish_commenter;
	
		
	private Micro_wish micro_wish;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWish_comment_content() {
		return wish_comment_content;
	}

	public void setWish_comment_content(String wishCommentContent) {
		wish_comment_content = wishCommentContent;
	}

	public Date getWish_comment_time() {
		return wish_comment_time;
	}

	public void setWish_comment_time(Date wishCommentTime) {
		wish_comment_time = wishCommentTime;
	}

	public int getWish_commenter() {
		return wish_commenter;
	}

	public void setWish_commenter(int wishCommenter) {
		wish_commenter = wishCommenter;
	}


	public Micro_wish getMicro_wish() {
		return micro_wish;
	}

	public void setMicro_wish(Micro_wish microWish) {
		micro_wish = microWish;
	}
}
