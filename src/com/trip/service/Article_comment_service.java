package com.trip.service;

import java.util.List;

import com.trip.bean.Article_comment;


public interface Article_comment_service {
	
	
	    public void saveArticle_comment(Article_comment article_comment);//����
		
		public void removeArticle_comment(Article_comment article_comment);//ɾ��
		
		public List<Article_comment> allArticle_comment();//��������
		
		public Article_comment findArticle_commentById(int id);//����
		
		public void updateArticle_comment(Article_comment article_comment);//����
	
	
	    

}
