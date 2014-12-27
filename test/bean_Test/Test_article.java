package bean_Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trip.DAO.User_Dao;
import com.trip.DAO.Impl.User_Dao_Impl;
import com.trip.bean.Article;
import com.trip.bean.Article_comment;
import com.trip.bean.User;
import com.trip.service.User_service;
import com.trip.service.Impl.User_service_Impl;
import com.trip.util.hibernateUtil;

import junit.framework.TestCase;

public class Test_article extends TestCase {
	Session session=null;
/**
 * ���ӷ�������
 */
	public void test_add(){
		session=hibernateUtil.getSession();
		session.beginTransaction();
		try {
			
		Article article=new Article();
		article.setTitle("�Ұ��㰡");
		article.setContent("���������İ���İ������ѵ���֪����");
		article.setDateline(new Date());
		
		session.save(article);
		
		Article_comment ac1=new Article_comment();
		ac1.setComment_content("����ɵ����ô������");
		ac1.setComment_time(new Date());
		ac1.setArticle(article);
		session.save(ac1);
		
		Article_comment ac2=new Article_comment();
		ac2.setComment_content("����Ҫ��������Ҫ���Żر��ͺ��ˡ�");
		ac2.setComment_time(new Date());
		ac2.setArticle(article);
		session.save(ac2);
		
		session.getTransaction().commit();
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
	}
	
/**
 * ��ѯ����1	����һ��ѯ�ࣩ
 */
	@SuppressWarnings("unchecked")
	public void test_load1(){
		session=hibernateUtil.getSession();
		session.beginTransaction();
		try {
			
		Article article=new Article();
		article=(Article)session.get(Article.class, 1);
		System.out.println("���±���Ϊ"+article.getTitle());
		
		System.out.println("��������Ϊ"+article.getContent());
		
		System.out.println("��������ʱ��Ϊ"+article.getDateline());
		
		Set set=article.getArticle_comments();
		for(Iterator iter=set.iterator();iter.hasNext();){
			Article_comment ac=new Article_comment();
			ac=(Article_comment)iter.next();
			System.out.println("��������Ϊ��"+ac.getComment_content());
			System.out.println("����ʱ��Ϊ��"+ac.getComment_time());
			
			
		}
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
	}
/**
 * ��ѯ����2���Ӷ��ѯ�٣�	
 */
	
	
	public void test_load2(){
		session=hibernateUtil.getSession();
		session.beginTransaction();
		try {
			
		Article_comment ac=(Article_comment)session.get(Article_comment.class, 1);
		System.out.println("��������Ϊ��"+ac.getComment_content());
		System.out.println("����ʱ��Ϊ"+ac.getComment_time());
		
		System.out.println("�����۵����±���Ϊ��"+ac.getArticle().getTitle());
			
		System.out.println("�����۵���������Ϊ��"+ac.getArticle().getContent());	
		
		
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
	}
	
/**
 * �����޸�����	
 */
	public void test_update(){
		session=hibernateUtil.getSession();
		session.beginTransaction();
		try {
			
		Article article=(Article)session.get(Article.class, 1);
		article.setTitle("�ҿ첻��������������");
		article.setDateline(new Date());
		session.update(article);
			
	    Article_comment ac=(Article_comment)session.get(Article_comment.class, 1);
	    ac.setComment_content("������˱仯��찡������");
	    ac.setComment_time(new Date());
	    session.update(ac);
			
		
		session.getTransaction().commit();
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
	}
/**
 * ���Լ���ɾ��	
 */
	public void test_delete(){
		session=hibernateUtil.getSession();
		session.beginTransaction();
		try {
		
	    Article a=(Article)session.get(Article.class, 1);
		session.delete(a);
		
		
		session.getTransaction().commit();
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
	}
	
	public void test_user_findbyname(){
		try {
	  BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	  User_Dao service = (User_Dao)factory.getBean("User_Dao");	
		
	  //User_Dao service=new User_Dao_Impl();
		List list=new ArrayList();
		list=service.findUserByName("sue");
		//String HQL="from User user where user.username=?";
		//List list=session.createQuery("from User user where user.username='wn398'").list();
		
		Iterator it = list.iterator();
		while(it.hasNext() ) {
		      User user = (User)it.next();
		      System.out.println(user.getUsername());
		}
		
		
			
			
		
		
		
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally{
			hibernateUtil.closeSession(session);
		}
		
		
		
	}
	
}
