package com.trip.bean;

import java.util.Set;
/**
 * 
 *���·����
 *
 */
@SuppressWarnings("unchecked")
public class Article_categroy {
	private int id;
	
	private String categroy_name;//��������
	
	private int categroy_level;//���༶��
	
	
	private Set articles;//������������
	
	private User user;//�û�ʹ����

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
