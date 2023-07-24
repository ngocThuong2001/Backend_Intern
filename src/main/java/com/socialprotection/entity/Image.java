package com.socialprotection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private long imageId;
	@Column(name = "image_url")
	private String imageUrl;

	@OneToOne(mappedBy = "images")
	private Employee employees;

	@OneToOne(mappedBy = "imageChild")
	private Children children;

	public long getImageId() {
		return imageId;
	}

//	public void setImageId(long imageId) {
//		this.imageId = imageId;
//	}



	public Employee getEmployees() {
		return employees;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public Image(String imageUrl, Employee employees, Children children) {
		super();
		this.imageUrl = imageUrl;
		this.employees = employees;
		this.children = children;
	}

	public Image() {
		super();
	}

	

}