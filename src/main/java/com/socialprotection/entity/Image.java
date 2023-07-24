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

	@OneToOne(mappedBy = "image")
	private Employee employee;

	@OneToOne(mappedBy = "image")
	private Children children;
	
	@OneToOne(mappedBy = "image")
	private Article	article;

	public long getImageId() {
		return imageId;
	}

//	public void setImageId(long imageId) {
//		this.imageId = imageId;
//	}



	public Employee getEmployee() {
		return employee;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	

}