package com.trip.DAO.Impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.Friend_Dao;
import com.trip.bean.Friend;

public class Friend_Dao_Impl extends HibernateDaoSupport implements Friend_Dao {

	@SuppressWarnings("unchecked")
	public List<Friend> allFriend() {
		
		String HQL="from Friend friend order by friend.id desc";
		return (List<Friend>)this.getHibernateTemplate().find(HQL);
	}

	public Friend findFriendByID(int id) {
		return this.getHibernateTemplate().load(Friend.class, id);
	}

	public void removeFriend(Friend friend) {
		
		this.getHibernateTemplate().delete(friend);
		
	}

	public void savaFriend(Friend friend) {
		this.getHibernateTemplate().save(friend);
		
	}

	public void updateFriend(Friend friend) {
		this.getHibernateTemplate().update(friend);
		
	}


}
