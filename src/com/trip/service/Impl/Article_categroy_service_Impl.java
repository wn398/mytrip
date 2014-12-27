package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Article_categroy_Dao;
import com.trip.bean.Article_categroy;
import com.trip.service.Article_categroy_service;

public class Article_categroy_service_Impl implements Article_categroy_service {
	
	
	 private Article_categroy_Dao  article_categroy_dao;
		
		
		public Article_categroy_Dao getArticle_categroy_dao() {
			return article_categroy_dao;
		}

		public void setArticle_categroy_dao(Article_categroy_Dao article_categroy_Dao) {
			article_categroy_dao = article_categroy_Dao;
		}

		public void removeArticle_categroy(Article_categroy article_categroy) {
			this.article_categroy_dao.removeArticle_categroy(article_categroy);

		}

		public void saveArticle_categroy(Article_categroy article_categroy) {
			this.article_categroy_dao.savaArticle_categroy(article_categroy);

		}

		 public List<Article_categroy> allArticle_categroy() {
		
			return this.article_categroy_dao.allArticle_categroy();
			
			
		}

		public Article_categroy findArticle_categroyById(int id) {
			return this.article_categroy_dao.findArticle_categroyByID(id);
		}

		
		public void updateArticle_categroy(Article_categroy article_categroy) {
			this.article_categroy_dao.updateArticle_categroy(article_categroy);
		}

}
