package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article_comment;

public interface Article_comment_Dao {
	
    public void removeArticle_comment(Article_comment article_comment);//�����ݿ�ɾ��ĳ����������
	
	public void savaArticle_comment(Article_comment article_comment);//���������۴��뵽���ݿ���
	
	public List<Article_comment> allArticle_comment();//�����ݿ��в�ѯ����������������Ϣ
	
	public Article_comment findArticle_commentByID(int id);//������������ID��ѯ��������
	
	public void updateArticle_comment(Article_comment photo);//��������������Ϣ


}
