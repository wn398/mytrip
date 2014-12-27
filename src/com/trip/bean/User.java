package com.trip.bean;

import java.util.Date;
import java.util.Set;
/**
 * 
 * 用户表类
 *
 */
@SuppressWarnings("unchecked")
public class User {
	private int id;
	
	private String username;//用户名
	
	private String password;//密码
	
	private String repassword;//没有到数据库
	
	private String question;//密码问题
	
	private String answer;//密码答案
	
	private String nick_name;//妮称
	
	private boolean sex;//性别
	
	private Date birthday;//出生日期
	
	private String address;//现居地
	
	private String self_introduction;//自我介绍
	
	//private String wish;//近期心愿
	
	private String email;//电子邮件地址
	
	private String avatar;//头像路径
	
	private Date register_time;//注册时间
	
	private Set articles;//文章
	
	private Set article_categroy;//文章分类
	
	private Set photos;//相片
	
	private Set albums;//相片分类
	
	private Set friends;//好友
	
	private Set fridend_categroys;//好友分类

	private Set micro_wish;//微心愿
	
	public Set getMicro_wish() {
		return micro_wish;
	}

	public void setMicro_wish(Set microWish) {
		micro_wish = microWish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nickName) {
		nick_name = nickName;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSelf_introduction() {
		return self_introduction;
	}

	public void setSelf_introduction(String selfIntroduction) {
		self_introduction = selfIntroduction;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
 
	public Date getRegister_time() {
		return register_time;
	}

	public void setRegister_time(Date registerTime) {
		register_time = registerTime;
	}

	
	public Set getArticles() {
		return articles;
	}

	public void setArticles(Set articles) {
		this.articles = articles;
	}

	public Set getArticle_categroy() {
		return article_categroy;
	}

	public void setArticle_categroy(Set articleCategroy) {
		article_categroy = articleCategroy;
	}

	public Set getPhotos() {
		return photos;
	}

	public void setPhotos(Set photos) {
		this.photos = photos;
	}

	public Set getAlbums() {
		return albums;
	}

	public void setAlbums(Set albums) {
		this.albums = albums;
	}

	public Set getFriends() {
		return friends;
	}

	public void setFriends(Set friends) {
		this.friends = friends;
	}

	public Set getFridend_categroys() {
		return fridend_categroys;
	}

	public void setFridend_categroys(Set fridendCategroys) {
		fridend_categroys = fridendCategroys;
	}

	

}
