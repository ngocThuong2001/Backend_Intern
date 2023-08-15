package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Article;
import com.socialprotection.entity.Category;
import com.socialprotection.repository.ArticleRepository;
import com.socialprotection.repository.ImageRepository;
import com.socialprotection.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ImageRepository imageRepository;

	@Override
	public Article saveArticle(Article article) {
		imageRepository.save(article.getImage());
		return articleRepository.save(article);
	}

	@Override
	public List<Article> getArticles(Integer limit) {
		// TODO Auto-generated method stub
		Pageable pageable = null;
		if (limit != null) {
			Sort sortDesc = new Sort(Sort.Direction.DESC, "postDate");
			pageable = new PageRequest(0, limit, sortDesc);
		}
		return articleRepository.findAll(pageable).getContent();
	}

	@Override
	public void deleteArticle(Long articalId) {
		// TODO Auto-generated method stub
		articleRepository.delete(articalId);
	}

	@Override
	public Article findById(long id) {
		return articleRepository.findOne(id);
	}

	@Override
	public List<Article> getArticlesByCategory(Category category) {
		// TODO Auto-generated method stub
		return articleRepository.findByCategory(category);
	}

	@Override
	public List<Article> getArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return articleRepository.findByTitle(title);
	}

	@Override
	public Article updateArticle(Article article) {
		// TODO Auto-generated method stub
		return articleRepository.save(article);
	}

}
