package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Article;
import com.socialprotection.entity.Category;

public interface ArticleService {
	Article saveArticle(Article article);

	List<Article> getArticles(Integer limit);

	Article findById(long id);

	List<Article> getArticlesByCategory(Category category);

	void deleteArticle(Long articalId);

	
	List<Article> getArticleByTitle(String title);
	
	Article updateArticle(Article article);
}
