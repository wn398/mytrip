package com.trip.service;

import java.util.List;

import com.trip.bean.Article_categroy;

public interface Article_categroy_service {
	
	
	
	    public void saveArticle_categroy(Article_categroy article_categroy);//����
		
		public void removeArticle_categroy(Article_categroy article_categroy);//ɾ��
		
		public List<Article_categroy> allArticle_categroy();//��������
		
		public Article_categroy findArticle_categroyById(int id);//����
		
		public void updateArticle_categroy(Article_categroy article_categroy);//����

}
