package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "budgets")
public class Budget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "budget_id")
	private long budgetId;
	
	@Column(name = "budget_name")
	private String budgetName;
	
	@Column(name = "budget_description")
	private String budgetDescription;
	
	@Column(name = "amount")
	private float amout;
	
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "end_date")
	private Date endDate;

	@OneToMany(mappedBy = "donation")
	private Donation donation;
	
	public Budget() {
		super();
	}

	public Budget(String budgetName, String budgetDescription, float amout, Date startDate, Date endDate,
			Donation donation) {
		super();
		this.budgetName = budgetName;
		this.budgetDescription = budgetDescription;
		this.amout = amout;
		this.startDate = startDate;
		this.endDate = endDate;
		this.donation = donation;
	}

	public String getBudgetName() {
		return budgetName;
	}

	public void setBudgetName(String budgetName) {
		this.budgetName = budgetName;
	}

	public String getBudgetDescription() {
		return budgetDescription;
	}

	public void setBudgetDescription(String budgetDescription) {
		this.budgetDescription = budgetDescription;
	}

	public Float getAmout() {
		return amout;
	}

	public void setAmout(Float amout) {
		this.amout = amout;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}
	
}
