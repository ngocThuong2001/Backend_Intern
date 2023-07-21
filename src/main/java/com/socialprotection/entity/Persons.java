package com.socialprotection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Persons {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int person_id;

	@Column(name = "full_name")
	private String full_name;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	@Column(name = "gender")
	private String gender;

	@Column(name = "nationality")
	private String nationality;

	@OneToOne(mappedBy = "persons")
	private Employees employees;

	@OneToOne(mappedBy = "person_child")
	private Children children;

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public int getPerson_id() {
		return person_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Persons(int person_id, String full_name, String first_name, String last_name, String gender,
			String nationality) {
		super();
		this.person_id = person_id;
		this.full_name = full_name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.nationality = nationality;
	}

	public Persons() {
		super();
	}

}
