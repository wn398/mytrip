package com.trip.service.Impl;

import java.util.List;

import com.trip.DAO.Article_comment_Dao;
import com.trip.bean.Article_comment;
import com.trip.service.Article_comment_service;

public class Article_comment_service_Impl implements Article_comment_service {
	
	
	 private Article_comment_Dao  article_comment_dao;
		
		
		public Article_comment_Dao getArticle_comment_dao() {
			return article_comment_dao;
		}

		public void setArticle_comment_dao(Article_comment_Dao article_comment_Dao) {
			article_comment_dao = article_comment_Dao;
		}

		public void removeArticle_comment(Article_comment article_comment) {
			this.article_comment_dao.removeArticle_comment(article_comment);

		}

		public void saveArticle_comment(Article_comment article_comment) {
			this.article_comment_dao.savaArticle_comment(article_comment);

		}

		 public List<Article_comment> allArticle_comment() {
		
			return this.article_comment_dao.allArticle_comment();
			
			
		}

		public Article_comment findArticle_commentById(int id) {
			return this.article_comment_dao.findArticle_commentByID(id);
		}

		
		public void updateArticle_comment(Article_comment article_comment) {
			this.article_comment_dao.updateArticle_comment(article_comment);
		}

}
