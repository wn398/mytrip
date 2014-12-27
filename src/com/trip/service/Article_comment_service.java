package com.trip.service;

import java.util.List;

import com.trip.bean.Article_comment;


public interface Article_comment_service {
	
	
	    public void saveArticle_comment(Article_comment article_comment);//保存
		
		public void removeArticle_comment(Article_comment article_comment);//删除
		
		public List<Article_comment> allArticle_comment();//返回所有
		
		public Article_comment findArticle_commentById(int id);//查找
		
		public void updateArticle_comment(Article_comment article_comment);//更新
	
	
	    

}
