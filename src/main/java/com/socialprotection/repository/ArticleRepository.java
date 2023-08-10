package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Article;
import com.socialprotection.entity.Category;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	List<Article> findByCategory(Category category);
}
