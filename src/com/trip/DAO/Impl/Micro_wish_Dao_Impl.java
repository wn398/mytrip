package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Micro_wish_Dao;
import com.trip.bean.Micro_wish;

public class Micro_wish_Dao_Impl extends HibernateDaoSupport implements
		Micro_wish_Dao {

	@SuppressWarnings("unchecked")
	public List<Micro_wish> allMicro_wish() {
		
		String HQL="from Micro_wish micro_wish order by micro_wish.id desc";
		return (List<Micro_wish>)this.getHibernateTemplate().find(HQL);
	}

	public Micro_wish findMicro_wishByID(int id) {
		return this.getHibernateTemplate().get(Micro_wish.class, id);
	}

	public void removeMicro_wish(Micro_wish micro_wish) {
		
		this.getHibernateTemplate().delete(micro_wish);
		
	}

	public void savaMicro_wish(Micro_wish micro_wish) {
		this.getHibernateTemplate().save(micro_wish);
		
	}

	public void updateMicro_wish(Micro_wish micro_wish) {
		this.getHibernateTemplate().update(micro_wish);
		
	}


}
