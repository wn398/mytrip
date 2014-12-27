package bean_Test;

import java.util.Date;

import org.hibernate.Session;

import com.trip.bean.Article;
import com.trip.bean.Article_comment;
import com.trip.util.hibernateUtil;

import junit.framework.TestCase;

public class test_all extends TestCase {
	
	Session session=null;
	/**
	 * ���ӷ�������
	 */
		public void test_add(){
			session=hibernateUtil.getSession();
			session.beginTransaction();
			try {
				
			Article article1=new Article();
			article1.setTitle("�Ұ��㰡");
			article1.setContent("���������İ���İ������ѵ���֪����");
			article1.setDateline(new Date());
			session.save(article1);
			
			Article_comment ac1=new Article_comment();
			ac1.setComment_content("����ɵ����ô������");
			ac1.setComment_time(new Date());
			ac1.setArticle(article1);
			session.save(ac1);
			
			Article_comment ac2=new Article_comment();
			ac2.setComment_content("����Ҫ��������Ҫ���Żر��ͺ��ˡ�");
			ac2.setComment_time(new Date());
			ac2.setArticle(article1);
			session.save(ac2);
			
			session.getTransaction().commit();
			
			
				
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			}finally{
				hibernateUtil.closeSession(session);
			}
			
		}
		

}
