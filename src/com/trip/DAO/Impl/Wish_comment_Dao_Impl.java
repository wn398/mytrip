package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Wish_comment_Dao;
import com.trip.bean.Wish_comment;

public class Wish_comment_Dao_Impl extends HibernateDaoSupport implements
		Wish_comment_Dao {

	@SuppressWarnings("unchecked")
	
	
	public List<Wish_comment> allWish_comment() {
		
		String HQL="from Wish_comment wish_comment order by wish_comment.id desc";
		return (List<Wish_comment>)this.getHibernateTemplate().find(HQL);
	}

	public Wish_comment findWish_commentByID(int id) {
		return this.getHibernateTemplate().get(Wish_comment.class, id);
	}

	public void removeWish_comment(Wish_comment wish_comment) {
		
		this.getHibernateTemplate().delete(wish_comment);
		
	}

	public void savaWish_comment(Wish_comment wish_comment) {
		this.getHibernateTemplate().save(wish_comment);
		
	}

	public void updateWish_comment(Wish_comment wish_comment) {
		this.getHibernateTemplate().update(wish_comment);
		
	}


}
