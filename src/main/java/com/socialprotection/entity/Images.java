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
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private long imageId;
	@Column(name = "medical_url")
	private String medicalUrl;

	@OneToOne(mappedBy = "images")
	private Employees employees;

	@OneToOne(mappedBy = "imageChild")
	private Children children;

	public long getImageId() {
		return imageId;
	}

//	public void setImageId(long imageId) {
//		this.imageId = imageId;
//	}

	public String getMedicalUrl() {
		return medicalUrl;
	}

	public void setMedicalUrl(String medicalUrl) {
		this.medicalUrl = medicalUrl;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	

}
