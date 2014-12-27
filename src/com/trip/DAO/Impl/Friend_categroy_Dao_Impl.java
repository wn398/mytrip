package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Friend_categroy_Dao;
import com.trip.bean.Friend_categroy;

public class Friend_categroy_Dao_Impl extends HibernateDaoSupport implements
		Friend_categroy_Dao {

	@SuppressWarnings("unchecked")
	public List<Friend_categroy> allFriend_categroy() {
		
		String HQL="from Friend_categroy friend_categroy order by friend_categroy.id desc";
		return (List<Friend_categroy>)this.getHibernateTemplate().find(HQL);
	}

	public Friend_categroy findFriend_categroyByID(int id) {
		return this.getHibernateTemplate().get(Friend_categroy.class, id);
	}

	public void removeFriend_categroy(Friend_categroy friend_categroy) {
		
		this.getHibernateTemplate().delete(friend_categroy);
		
	}

	public void savaFriend_categroy(Friend_categroy friend_categroy) {
		this.getHibernateTemplate().save(friend_categroy);
		
	}

	public void updateFriend_categroy(Friend_categroy friend_categroy) {
		this.getHibernateTemplate().update(friend_categroy);
		
	}


}
