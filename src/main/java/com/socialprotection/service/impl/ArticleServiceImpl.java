package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Article;
import com.socialprotection.repository.ArticleRepository;
import com.socialprotection.repository.CategoryRepository;
import com.socialprotection.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	private ArticleRepository articleRepository;
	
	

	@Override
	public Article saveArticle(Article article) {
		// TODO Auto-generated method stub
		
		return articleRepository.save(article);
	}

	@Override
	public List<Article> getArticles() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public void deleteArticle(Long articalId) {
		// TODO Auto-generated method stub
		articleRepository.delete(articalId);
	}

}
