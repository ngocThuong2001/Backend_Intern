package com.socialprotection.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "adoptions")
public class Adoption {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adoption_id")
	private long adoptionId;
	
	@Column(name = "register_date")
	private Date registerDate;
	
	@Column(name = "status")
	private char status;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_id")
	private Children children;
	
	@OneToMany(mappedBy = "adoption")
	private List<Adopter> adopters;
	
	

	public long getAdoptionId() {
		return adoptionId;
	}

//	public void setAdoptionId(long adoptionId) {
//		this.adoptionId = adoptionId;
//	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	

	

	public List<Adopter> getAdopters() {
		return adopters;
	}

	public void setAdopters(List<Adopter> adopters) {
		this.adopters = adopters;
	}

	
	
	public Adoption(Date registerDate, char status) {
		super();
		this.registerDate = registerDate;
		this.status = status;
	}

	public Adoption() {
		super();
	}
	
	
	

}
