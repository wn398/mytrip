package com.trip.bean;

import java.util.Date;
//��������ʵ��
public class Article_comment {
     private int id;//���ݿ���id
     
     private String comment_content;//��������
     
     private int comment_person_id;//�����˵�id
     
     private Date comment_time;//����ʱ��
     
     private Article article;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getComment_person_id() {
		return comment_person_id;
	}

	public void setComment_person_id(int commentPersonId) {
		comment_person_id = commentPersonId;
	}

	public void setComment_time(Date commentTime) {
		comment_time = commentTime;
	}
	
	
}
