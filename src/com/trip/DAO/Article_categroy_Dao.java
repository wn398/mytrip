package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article_categroy;

public interface Article_categroy_Dao {
	
     public void removeArticle_categroy(Article_categroy article_categroy);//�����ݿ�ɾ��ĳ�����·���
	
	public void savaArticle_categroy(Article_categroy article_categroy);//�����·�����뵽���ݿ���
	
	public List<Article_categroy> allArticle_categroy();//�����ݿ��в�ѯ���������·�����Ϣ
	
	public Article_categroy findArticle_categroyByID(int id);//�������·���ID��ѯ���·���
	
	public void updateArticle_categroy(Article_categroy article_categroy);//������Ƭ��Ϣ


}
