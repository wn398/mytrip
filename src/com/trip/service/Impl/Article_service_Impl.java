package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Article_Dao;
import com.trip.bean.Article;
import com.trip.service.Article_service;



public class Article_service_Impl implements Article_service {
	
	
	   private Article_Dao  article_dao;
		
		
		public Article_Dao getArticle_dao() {
			return article_dao;
		}

		public void setArticle_dao(Article_Dao article_Dao) {
			article_dao = article_Dao;
		}

		public void removeArticle(Article article) {
			this.article_dao.removeArticle(article);

		}

		public void saveArticle(Article article) {
			this.article_dao.savaArticle(article);

		}

		 public List<Article> allArticle() {
		
			return this.article_dao.allArticle();
			
			
		}

		public Article findArticleById(int id) {
			return this.article_dao.findArticleByID(id);
		}

		
		public void updateArticle(Article article) {
			this.article_dao.updateArticle(article);
		}

	
		
}
