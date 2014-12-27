package com.trip.bean;

import java.util.Date;
import java.util.Set;

@SuppressWarnings("unchecked")
//文章实体
public class Article {
	private int id;//文章表的id
	
	private String title;//文章的标题
		
	private String content;//文章内容
	
	private Date dateline;//文章发表时间
	
	private int read_count;//文章的阅读次数
	
	private int comment_count;//文章的评论总数,只是一个记录字段，并没有在数据库中映射
	
	private String time;//没有在数据库中映射　时间的字符串输出
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	private Set article_comments;//文章的评论
	
	private User user;//文章拥有的用户
	
	private Article_categroy article_categroy;//文章的所属分类
	
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
