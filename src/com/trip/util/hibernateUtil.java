package com.trip.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
	static SessionFactory factory=null;
	static Session session=null;
	  static{
		try {
			//读取配置文件（hibernate.cfg.xml）
			Configuration cfg=new Configuration().configure();
			//根据配置文件取得SessionFactory工厂
	        factory=cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//取得Session
	public static Session getSession(){
       	
		session=factory.openSession();
		return session;
	}
	public static void closeSession(Session session){
		if(session!=null){
			if(session.isOpen())
				session.close();
		}
		
	}

}
