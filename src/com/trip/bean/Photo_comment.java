package com.trip.bean;

import java.util.Date;

public class Photo_comment {
	private int id;
	
	private int commenter_id;//�����˵�id
	
	private String comment_content;//��������
	
	private Date comment_time;//����ʱ��
	
	private Photo photo;//�����۵���Ƭ

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommenter_id() {
		return commenter_id;
	}

	public void setCommenter_id(int commenterId) {
		commenter_id = commenterId;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String commentContent) {
		comment_content = commentContent;
	}

	public Date getComment_time() {
		return comment_time;
	}

	public void setComment_time(Date commentTime) {
		comment_time = commentTime;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

}
