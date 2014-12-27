package com.trip.bean;

import java.util.Set;
/**
 * 
 *文章分类表
 *
 */
@SuppressWarnings("unchecked")
public class Article_categroy {
	private int id;
	
	private String categroy_name;//分类名称
	
	private int categroy_level;//分类级别
	
	
	private Set articles;//类下所属文章
	
	private User user;//用户使用者

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategroy_name() {
		return categroy_name;
	}

	public void setCategroy_name(String categroyName) {
		categroy_name = categroyName;
	}

	public int getCategroy_level() {
		return categroy_level;
	}

	public void setCategroy_level(int categroyLevel) {
		categroy_level = categroyLevel;
	}

	public Set getArticles() {
		return articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
