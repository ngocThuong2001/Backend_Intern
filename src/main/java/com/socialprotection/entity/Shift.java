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
@Table(name = "shifts")
public class Shift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shift_id")
	private long shiftId;
	
	@Column(name = "shift_title")
	private String shiftTitle;
	
	@Column(name = "time_start")
	private Date timeStart;
	
	@Column(name = "time_end")
	private Date timeEnd;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public long getShiftId() {
		return shiftId;
	}

//	public void setShiftId(long shiftId) {
//		this.shiftId = shiftId;
//	}

	public String getShiftTitle() {
		return shiftTitle;
	}

	public void setShiftTitle(String shiftTitle) {
		this.shiftTitle = shiftTitle;
	}

	public Date getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	public Date getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Shift(String shiftTitle, Date timeStart, Date timeEnd, Employee employee) {
		super();
		this.shiftTitle = shiftTitle;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.employee = employee;
	}

	public Shift() {
		super();
	}

	
	
}
