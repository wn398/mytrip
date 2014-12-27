package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Photo_comment_Dao;
import com.trip.bean.Photo_comment;


public class Photo_comment_Dao_Impl extends HibernateDaoSupport implements
		Photo_comment_Dao {

	@SuppressWarnings("unchecked")
	public List<Photo_comment> allPhoto_comment() {
		
		String HQL="from Photo_comment photo_comment order by photo_comment.id desc";
		return (List<Photo_comment>)this.getHibernateTemplate().find(HQL);
	}

	public Photo_comment findPhoto_commentByID(int id) {
		return this.getHibernateTemplate().load(Photo_comment.class, id);
	}

	public void removePhoto_comment(Photo_comment photo_comment) {
		
		this.getHibernateTemplate().delete(photo_comment);
		
	}

	public void savaPhoto_comment(Photo_comment photo_comment) {
		this.getHibernateTemplate().save(photo_comment);
		
	}

	public void updatePhoto_comment(Photo_comment photo_comment) {
		this.getHibernateTemplate().update(photo_comment);
		
	}


}
