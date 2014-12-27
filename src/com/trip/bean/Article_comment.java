package com.trip.bean;

import java.util.Date;
//文章评论实体
public class Article_comment {
     private int id;//数据库中id
     
     private String comment_content;//评论内容
     
     private int comment_person_id;//评论人的id
     
     private Date comment_time;//评论时间
     
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
