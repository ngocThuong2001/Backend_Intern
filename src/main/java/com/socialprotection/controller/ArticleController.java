package com.socialprotection.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.services.drive.model.File;
import com.socialprotection.entity.Article;
import com.socialprotection.entity.Category;
import com.socialprotection.entity.Image;
import com.socialprotection.googledrivestore.GoogleDriveService;
import com.socialprotection.request.ArticleRequest;
import com.socialprotection.service.ArticleService;

@CrossOrigin
@RestController
@RequestMapping("/api")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
* 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private GoogleDriveService googleDriveService;
	
	@PostMapping(value = "/articles",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> saveArticle(@RequestPart("article") ArticleRequest request,
			@RequestPart("image") MultipartFile file) throws Exception{
		Article article = new Article();
		article.setCategory(request.getCategory());
		article.setContent(request.getContent());
		article.setTitle(request.getTitle());
		article.setArticleUrl(request.getArticleUrl());
		article.setPostDate(new Date(System.currentTimeMillis()));
		
		File googleFile = googleDriveService.uploadFile(file);
		String imageUrl = googleFile.getWebContentLink();
		Image image = new Image(imageUrl);
		
		article.setImage(image);
		
		return ResponseEntity.ok(articleService.saveArticle(article));
	}
	
	@GetMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> getArticles(@RequestParam(name = "limit", required = false) Integer limit){
		return ResponseEntity.ok(articleService.getArticles(limit));
	}
	
	@GetMapping(value = "/articles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Article> getArticle(@PathVariable("id") long id){
		return ResponseEntity.ok(articleService.findById(id));
	}
	
	@GetMapping(value = "category/{id}/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Article>> getArticlesByCateId(@PathVariable("id") long id){
		Category category = new Category();
		category.setCategoryId(id);
		return ResponseEntity.ok(articleService.getArticlesByCategory(category));
	}
	
	@DeleteMapping(value = "/articles/delete", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteArticle(@RequestParam Long articleId) {
		articleService.deleteArticle(articleId);
	}

}
