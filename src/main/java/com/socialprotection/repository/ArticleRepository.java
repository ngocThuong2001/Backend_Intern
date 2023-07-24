package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
