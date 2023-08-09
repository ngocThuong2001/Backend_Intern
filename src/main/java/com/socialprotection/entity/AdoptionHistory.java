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
@Table(name = "adoption_history")
public class AdoptionHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adopt_history_id")
	private long adoptHistoryId;
	
	@Column(name = "adopt_date")
	private Date adoptDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "adopter_id")
	private Adopter adopter;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "child_id")
	private Children children;

	public long getAdoptHistoryId() {
		return adoptHistoryId;
	}

//	public void setAdoptHistoryId(long adoptHistoryId) {
//		this.adoptHistoryId = adoptHistoryId;
//	}

	public Date getAdoptDate() {
		return adoptDate;
	}

	public void setAdoptDate(Date adoptDate) {
		this.adoptDate = adoptDate;
	}

	public Adopter getAdopter() {
		return adopter;
	}

	public void setAdopter(Adopter adopter) {
		this.adopter = adopter;
	}

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public AdoptionHistory(Date adoptDate, Adopter adopter, Children children) {
		super();
		this.adoptDate = adoptDate;
		this.adopter = adopter;
		this.children = children;
	}

	public AdoptionHistory() {
		super();
	}
	
	

}
