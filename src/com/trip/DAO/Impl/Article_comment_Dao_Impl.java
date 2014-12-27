package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Article_comment_Dao;
import com.trip.bean.Article_comment;

public class Article_comment_Dao_Impl extends HibernateDaoSupport implements
		Article_comment_Dao {

	@SuppressWarnings("unchecked")
	public List<Article_comment> allArticle_comment() {
		
		String HQL="from Article_comment article_comment order by article_comment.id desc";
		return (List<Article_comment>)this.getHibernateTemplate().find(HQL);
	}

	public Article_comment findArticle_commentByID(int id) {
		return this.getHibernateTemplate().get(Article_comment.class, id);
	}

	public void removeArticle_comment(Article_comment article_comment) {
		
		this.getHibernateTemplate().delete(article_comment);
		
	}

	public void savaArticle_comment(Article_comment article_comment) {
		this.getHibernateTemplate().save(article_comment);
		
	}

	public void updateArticle_comment(Article_comment article_comment) {
		this.getHibernateTemplate().update(article_comment);
		
	}


}
