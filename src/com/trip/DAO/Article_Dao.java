package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article;

public interface Article_Dao {
	
   public void removeArticle(Article article);//从数据库删除某个文章
	
	public void savaArticle(Article article);//将文章存入到数据库中
	
	public List<Article> allArticle();//从数据库中查询出所有文章信息
	
	public Article findArticleByID(int id);//按照文章ID查询文章
	
	public void updateArticle(Article article);//更新文章信息


}
