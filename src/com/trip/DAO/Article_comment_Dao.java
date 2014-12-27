package com.trip.DAO;

import java.util.List;

import com.trip.bean.Article_comment;

public interface Article_comment_Dao {
	
    public void removeArticle_comment(Article_comment article_comment);//从数据库删除某个文章评论
	
	public void savaArticle_comment(Article_comment article_comment);//将文章评论存入到数据库中
	
	public List<Article_comment> allArticle_comment();//从数据库中查询出所有文章评论信息
	
	public Article_comment findArticle_commentByID(int id);//按照文章评论ID查询文章评论
	
	public void updateArticle_comment(Article_comment photo);//更新文章评论信息


}
