package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Article;

public interface ArticleService {
	public Article saveArticle(Article article);
	
	public List<Article> getArticles();
	
	public void deleteArticle(Long articalId);

}
