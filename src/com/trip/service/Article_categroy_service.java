package com.trip.service;

import java.util.List;

import com.trip.bean.Article_categroy;

public interface Article_categroy_service {
	
	
	
	    public void saveArticle_categroy(Article_categroy article_categroy);//保存
		
		public void removeArticle_categroy(Article_categroy article_categroy);//删除
		
		public List<Article_categroy> allArticle_categroy();//返回所有
		
		public Article_categroy findArticle_categroyById(int id);//查找
		
		public void updateArticle_categroy(Article_categroy article_categroy);//更新

}
