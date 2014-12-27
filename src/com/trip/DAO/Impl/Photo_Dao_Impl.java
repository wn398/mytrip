package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Photo_Dao;
import com.trip.bean.Photo;

public class Photo_Dao_Impl extends HibernateDaoSupport implements Photo_Dao {

	@SuppressWarnings("unchecked")
	public List<Photo> allPhoto() {
		
		String HQL="from Photo photo order by photo.id desc";
		return (List<Photo>)this.getHibernateTemplate().find(HQL);
	}

	public Photo findPhotoByID(int id) {
		return this.getHibernateTemplate().get(Photo.class, id);
	}

	public void removePhoto(Photo photo) {
		
		this.getHibernateTemplate().delete(photo);
		
	}

	public void savaPhoto(Photo photo) {
		this.getHibernateTemplate().save(photo);
		
	}

	public void updatePhoto(Photo photo) {
		this.getHibernateTemplate().update(photo);
		
	}


}
