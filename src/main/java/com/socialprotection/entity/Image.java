package com.socialprotection.entity;

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
	private long image_id;

	private String medical_url;

	@OneToOne(mappedBy = "images")
	private Employee employees;

	@OneToOne(mappedBy = "image_child")
	private Children children;

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public Employee getEmployees() {
		return employees;
	}

	public void setEmployees(Employee employees) {
		this.employees = employees;
	}

	public long getImage_id() {
		return image_id;
	}

	public String getMedical_url() {
		return medical_url;
	}

	public void setMedical_url(String medical_url) {
		this.medical_url = medical_url;
	}

}
