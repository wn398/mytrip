package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Article_Dao;
import com.trip.bean.Article;

public class Article_Dao_Impl extends HibernateDaoSupport implements
		Article_Dao {

	@SuppressWarnings("unchecked")
	public List<Article> allArticle() {
		
		String HQL="from Article article order by article.id desc";
		return (List<Article>)this.getHibernateTemplate().find(HQL);
	}

	public Article findArticleByID(int id) {
		return this.getHibernateTemplate().get(Article.class, id);
	}

	public void removeArticle(Article article) {
		
		this.getHibernateTemplate().delete(article);
		
	}

	public void savaArticle(Article article) {
		this.getHibernateTemplate().save(article);
		
	}

	public void updateArticle(Article article) {
		this.getHibernateTemplate().update(article);
		
	}

}
