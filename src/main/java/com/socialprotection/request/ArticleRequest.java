package com.socialprotection.request;

import com.socialprotection.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleRequest {
	private String title;
	private String content;
	private Category category;
	private String articleUrl;

	public ArticleRequest(String title, String content, Category category, String articleUrl) {
		super();
		this.title = title;
		this.content = content;
		this.category = category;
		this.articleUrl = articleUrl;
	}

	public ArticleRequest() {
		super();
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

	@Override
	public String toString() {
		return "ArticleRequest [title=" + title + ", content=" + content + ", category=" + category + ", articleUrl="
				+ articleUrl + "]";
	}


}
