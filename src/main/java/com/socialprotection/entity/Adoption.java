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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_id")
	private Children children;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adopter_id")
	private Adopter adopter;

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

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public Adoption(Date registerDate, char status, Children children, Adopter adopter) {
		super();
		this.registerDate = registerDate;
		this.status = status;
		this.children = children;
		this.adopter = adopter;
	}

	public Adoption() {
		super();
	}
	
	
	

}
