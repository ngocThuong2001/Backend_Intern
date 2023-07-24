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
@Table(name = "donations")
public class Donation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donation_id")
	private long donationId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "donor_id")
	private Donor donor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "budget_id")
	private Budget budget;

	@Column(name = "amount")
	private float amount;

	@Column(name = "date_time")
	private Date dateTime;

	@Column(name = "reason")
	private String reason;

	public Donation() {
		super();
	}

	public Donation(Donor donor, Budget budget, float amount, Date dateTime, String reason) {
		super();
		this.donor = donor;
		this.budget = budget;
		this.amount = amount;
		this.dateTime = dateTime;
		this.reason = reason;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
