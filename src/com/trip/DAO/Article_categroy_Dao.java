package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article_categroy;

public interface Article_categroy_Dao {
	
     public void removeArticle_categroy(Article_categroy article_categroy);//从数据库删除某个文章分类
	
	public void savaArticle_categroy(Article_categroy article_categroy);//将文章分类存入到数据库中
	
	public List<Article_categroy> allArticle_categroy();//从数据库中查询出所有文章分类信息
	
	public Article_categroy findArticle_categroyByID(int id);//按照文章分类ID查询文章分类
	
	public void updateArticle_categroy(Article_categroy article_categroy);//更新相片信息


}
