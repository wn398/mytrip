package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article;

public interface Article_Dao {
	
   public void removeArticle(Article article);//�����ݿ�ɾ��ĳ������
	
	public void savaArticle(Article article);//�����´��뵽���ݿ���
	
	public List<Article> allArticle();//�����ݿ��в�ѯ������������Ϣ
	
	public Article findArticleByID(int id);//��������ID��ѯ����
	
	public void updateArticle(Article article);//����������Ϣ


}
