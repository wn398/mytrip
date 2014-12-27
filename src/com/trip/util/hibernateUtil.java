package com.trip.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {
	static SessionFactory factory=null;
	static Session session=null;
	  static{
		try {
			//��ȡ�����ļ���hibernate.cfg.xml��
			Configuration cfg=new Configuration().configure();
			//���������ļ�ȡ��SessionFactory����
	        factory=cfg.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//ȡ��Session
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
