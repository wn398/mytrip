package com.trip.DAO.Impl;



import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.trip.DAO.User_Dao;
import com.trip.bean.User;

public class User_Dao_Impl extends HibernateDaoSupport implements User_Dao {

	@SuppressWarnings("unchecked")
	public List<User> allUser() {
		
		String HQL="from User user order by user.id desc";
		return (List<User>)this.getHibernateTemplate().find(HQL);
	}

	public User findUserByID(int id) {
		return this.getHibernateTemplate().get(User.class, id);
	}

	public void removeUser(User user) {
		
		this.getHibernateTemplate().delete(user);
		
	}

	public void savaUser(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
		
	}

	
	@SuppressWarnings("unchecked")
	public List<User> findUserByName(String username) {
		
		String HQL="from User user where user.username=?";
		//List list=hibernateUtil.getSession().createQuery(HQL).setParameter(0,username).list();
		//List list=this.getHibernateTemplate().find("from User user where user.username='wn398'");
		List list=this.getSession().createQuery(HQL).setParameter(0, username).list();
		return list;
	}

	public List<User> findRandom(int i) {
		List list = this.getSession().createQuery("from User  order by rand()").setMaxResults(i).list();
		
		return list;
	}



}
