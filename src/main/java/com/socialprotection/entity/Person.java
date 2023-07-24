package com.socialprotection.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private long personId;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "nationality")
	private String nationality;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(mappedBy = "person")
	private Employee employees;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(mappedBy = "person")
	private Children children;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(mappedBy = "person")
	private Adopter adopter;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(mappedBy = "personDonor")
	private Donor donor;

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public long getPersonId() {
		return personId;
	}

//	public void setPersonId(long personId) {
//		this.personId = personId;
//	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@JsonInclude(JsonInclude.Include.NON_NULL)
	public Employee getEmployees() {
		return employees;
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

	public Person(String fullName, String firstName, String lastName, String gender, String nationality) {
		super();
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.nationality = nationality;
	}

	public Person() {
		super();
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", fullName=" + fullName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", nationality=" + nationality + "]";
	}

}