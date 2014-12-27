package com.trip.bean;

import java.util.Set;
@SuppressWarnings("unchecked")
public class Photo {
	
	private int id;
	
	private String personal_photo;//存储相片的路径
	
	private String photo_introduction;//相处介绍
	
	private String photo_user;//相片的主人名，不在数据库中映射
	
	private int user_id;//相片的主人id号
	
	public String getPhoto_user() {
		return photo_user;
	}

	public void setPhoto_user(String photoUser) {
		photo_user = photoUser;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int userId) {
		user_id = userId;
	}

	private Set photo_comments;//相片评论
	
    
    private User user;//用户
    
    private Album album;//所属相册
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonal_photo() {
		return personal_photo;
	}

	public void setPersonal_photo(String personalPhoto) {
		personal_photo = personalPhoto;
	}

	public String getPhoto_introduction() {
		return photo_introduction;
	}

	public void setPhoto_introduction(String photoIntroduction) {
		photo_introduction = photoIntroduction;
	}
	
	public Set getPhoto_comments() {
		return photo_comments;
	}

	public void setPhoto_comments(Set photoComments) {
		photo_comments = photoComments;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
}
