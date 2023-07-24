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
import javax.persistence.Table;

@Entity
@Table(name = "salaries")
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private long salaryId;
	
	@Column(name = "salary")
	private float salary;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;
	
	@Column(name = "pay_date")
	private Date payDate;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee empSalary;

	public long getSalaryId() {
		return salaryId;
	}

//	public void setSalaryId(long salaryId) {
//		this.salaryId = salaryId;
//	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Employee getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Employee empSalary) {
		this.empSalary = empSalary;
	}

	public Salary(float salary, Date fromDate, Date toDate, Date payDate, boolean status, Employee empSalary) {
		super();
		this.salary = salary;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.payDate = payDate;
		this.status = status;
		this.empSalary = empSalary;
	}

	public Salary() {
		super();
	}
	
	

}
