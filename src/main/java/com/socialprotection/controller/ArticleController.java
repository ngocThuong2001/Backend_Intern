package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Article;
import com.socialprotection.service.ArticleService;

@CrossOrigin
@RestController
@RequestMapping("/api/articles")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Article> createArticle(@RequestBody Article article){
		return ResponseEntity.ok(articleService.saveArticle(article));
	}
	
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Article> getArticles(){
		return articleService.getArticles();
	}
	
	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteArticle(@RequestParam Long articleId) {
		articleService.deleteArticle(articleId);
	}

}
