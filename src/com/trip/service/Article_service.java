package com.trip.service;

import java.util.List;

import com.trip.bean.Article;


public interface Article_service {
	
 
	
	    public void saveArticle(Article article);//保存
		
		public void removeArticle(Article article);//删除
		
		public List<Article> allArticle();//返回所有
		
		public Article findArticleById(int id);//查找
		
		public void updateArticle(Article article);//更新

}
