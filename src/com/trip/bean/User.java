package com.trip.bean;

import java.util.Date;
import java.util.Set;
/**
 * 
 * �û�����
 *
 */
@SuppressWarnings("unchecked")
public class User {
	private int id;
	
	private String username;//�û���
	
	private String password;//����
	
	private String repassword;//û�е����ݿ�
	
	private String question;//��������
	
	private String answer;//�����
	
	private String nick_name;//�ݳ�
	
	private boolean sex;//�Ա�
	
	private Date birthday;//��������
	
	private String address;//�־ӵ�
	
	private String self_introduction;//���ҽ���
	
	//private String wish;//������Ը
	
	private String email;//�����ʼ���ַ
	
	private String avatar;//ͷ��·��
	
	private Date register_time;//ע��ʱ��
	
	private Set articles;//����
	
	private Set article_categroy;//���·���
	
	private Set photos;//��Ƭ
	
	private Set albums;//��Ƭ����
	
	private Set friends;//����
	
	private Set fridend_categroys;//���ѷ���

	private Set micro_wish;//΢��Ը
	
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
