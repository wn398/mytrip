package com.trip.bean;

import java.util.Date;
import java.util.Set;

@SuppressWarnings("unchecked")
//����ʵ��
public class Article {
	private int id;//���±��id
	
	private String title;//���µı���
		
	private String content;//��������
	
	private Date dateline;//���·���ʱ��
	
	private int read_count;//���µ��Ķ�����
	
	private int comment_count;//���µ���������,ֻ��һ����¼�ֶΣ���û�������ݿ���ӳ��
	
	private String time;//û�������ݿ���ӳ�䡡ʱ����ַ������
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private Set article_comments;//���µ�����
	
	private User user;//����ӵ�е��û�
	
	private Article_categroy article_categroy;//���µ���������
	
	public Article_categroy getArticle_categroy() {
		return article_categroy;
	}

	public void setArticle_categroy(Article_categroy articleCategroy) {
		article_categroy = articleCategroy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDateline() {
		return dateline;
	}

	public void setDateline(Date dateline) {
		this.dateline = dateline;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int readCount) {
		read_count = readCount;
	}

	public int getComment_count() {
		return comment_count;
	}

	public void setComment_count(int commentCount) {
		comment_count = commentCount;
	}

	public Set getArticle_comments() {
		return article_comments;
	}

	public void setArticle_comments(Set articleComments) {
		article_comments = articleComments;
	}
	

}
