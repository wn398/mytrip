package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Album_Dao;
import com.trip.bean.Album;

public class Album_Dao_Impl extends HibernateDaoSupport implements Album_Dao {

	@SuppressWarnings("unchecked")
	public List<Album> allAlbum() {
		
		String HQL="from Album album order by album.id desc";
		return (List<Album>)this.getHibernateTemplate().find(HQL);
	}

	public Album findAlbumByID(int id) {
		return this.getHibernateTemplate().get(Album.class, id);
	}

	public void removeAlbum(Album album) {
		
		this.getHibernateTemplate().delete(album);
		
	}

	public void savaAlbum(Album album) {
		this.getHibernateTemplate().save(album);
		
	}

	public void updateAlbum(Album album) {
		this.getHibernateTemplate().update(album);
		
	}


}
