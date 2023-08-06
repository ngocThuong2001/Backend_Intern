package com.socialprotection.dto;

import java.sql.Date;

public class IncomeDTO {

	private long budgetId;
	private long bankAccountId;
	private String incomeName;
	private String incomeDescription;	
	private float amount;
	private Date dateTime;
	
	public IncomeDTO() {
		super();
	}

	public IncomeDTO(long budgetId, long bankAccountId, String incomeName, String incomeDescription, float amount,
			Date dateTime) {
		super();
		this.budgetId = budgetId;
		this.bankAccountId = bankAccountId;
		this.incomeName = incomeName;
		this.incomeDescription = incomeDescription;
		this.amount = amount;
		this.dateTime = dateTime;
	}

	public long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(long budgetId) {
		this.budgetId = budgetId;
	}

	public long getBankAccountId() {
		return bankAccountId;
	}

	public void setBankAccountId(long bankAccountId) {
		this.bankAccountId = bankAccountId;
	}

	public String getIncomeName() {
		return incomeName;
	}

	public void setIncomeName(String incomeName) {
		this.incomeName = incomeName;
	}

	public String getIncomeDescription() {
		return incomeDescription;
	}

	public void setIncomeDescription(String incomeDescription) {
		this.incomeDescription = incomeDescription;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
}
