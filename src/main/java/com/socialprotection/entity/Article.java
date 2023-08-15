package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "articles")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "article_id")
	private long articleId;

	@Column(name = "title")
	private String title;

	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@Column(name = "article_url")
	private String articleUrl;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",  timezone = "Asia/Ho_Chi_Minh")
	@Column(name = "post_date")
	private Date postDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private Image image;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	private Category category;

	public Article() {
		super();
	}

	public Article(String title, String content, Date postDate, User user, Image image, Category category) {
		super();
		this.title = title;
		this.content = content;
		this.postDate = postDate;
		this.user = user;
		this.image = image;
		this.category = category;
	}

	public Article(String title, String content, String articleUrl, Date postDate, User user, Image image,
			Category category) {
		super();
		this.title = title;
		this.content = content;
		this.articleUrl = articleUrl;
		this.postDate = postDate;
		this.user = user;
		this.image = image;
		this.category = category;
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}

}
