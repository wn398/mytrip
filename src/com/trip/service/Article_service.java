package com.trip.service;

import java.util.List;

import com.trip.bean.Article;


public interface Article_service {
	
 
	
	    public void saveArticle(Article article);//����
		
		public void removeArticle(Article article);//ɾ��
		
		public List<Article> allArticle();//��������
		
		public Article findArticleById(int id);//����
		
		public void updateArticle(Article article);//����

}
