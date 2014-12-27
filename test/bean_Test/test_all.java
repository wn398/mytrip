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
	 * 增加方法测试
	 */
		public void test_add(){
			session=hibernateUtil.getSession();
			session.beginTransaction();
			try {
				
			Article article1=new Article();
			article1.setTitle("我爱你啊");
			article1.setContent("我是真的真的爱你的啊，你难道不知道吗？");
			article1.setDateline(new Date());
			session.save(article1);
			
			Article_comment ac1=new Article_comment();
			ac1.setComment_content("你真傻，那么爱她！");
			ac1.setComment_time(new Date());
			ac1.setArticle(article1);
			session.save(ac1);
			
			Article_comment ac2=new Article_comment();
			ac2.setComment_content("爱需要付出，不要想着回报就好了。");
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
