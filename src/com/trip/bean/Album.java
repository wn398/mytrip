package com.trip.bean;

import java.util.Date;
import java.util.Set;
/**
 * 
 * 相册实体
 *
 */
@SuppressWarnings("unchecked")
public class Album {
	
	private int id;
	
	private String album_name;//相册名
	
	private String album_introduction;//相册介绍
	
	private Date album_dateline;//创建时间
	
	private String cover_picture;//相册封面图片
	
	
	private User user;//相册拥有者
	
	private Set photos;//所包含相片

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String albumName) {
		album_name = albumName;
	}

	public String getAlbum_introduction() {
		return album_introduction;
	}

	public void setAlbum_introduction(String albumIntroduction) {
		album_introduction = albumIntroduction;
	}
    
	
	public String getCover_picture() {
		return cover_picture;
	}

	public void setCover_picture(String coverPicture) {
		cover_picture = coverPicture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set getPhotos() {
		return photos;
	}

	public void setPhotos(Set photos) {
		this.photos = photos;
	}

	public Date getAlbum_dateline() {
		return album_dateline;
	}

	public void setAlbum_dateline(Date albumDateline) {
		album_dateline = albumDateline;
	}

}
