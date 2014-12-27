package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Article_categroy_Dao;
import com.trip.bean.Article_categroy;

public class Article_categroy_Dao_Impl extends HibernateDaoSupport implements
		Article_categroy_Dao {

	@SuppressWarnings("unchecked")
	public List<Article_categroy> allArticle_categroy() {
		
		String HQL="from Article_categroy article_categroy order by article_categroy.id desc";
		return (List<Article_categroy>)this.getHibernateTemplate().find(HQL);
	}

	public Article_categroy findArticle_categroyByID(int id) {
		return this.getHibernateTemplate().get(Article_categroy.class, id);
	}

	public void removeArticle_categroy(Article_categroy article_categroy) {
		
		this.getHibernateTemplate().delete(article_categroy);
		
	}

	public void savaArticle_categroy(Article_categroy article_categroy) {
		this.getHibernateTemplate().save(article_categroy);
		
	}

	public void updateArticle_categroy(Article_categroy article_categroy) {
		this.getHibernateTemplate().update(article_categroy);
		
	}

}
