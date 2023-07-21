package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
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
@Table(name = "children")
public class Children {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "child_id")
	private long childId;
	
	@Column(name = "birthday")
	private Date birthDay;
	
	@Column(name = "status")
	private char status;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Persons personChild;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Images imageChild;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employees employeeChild;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orphan_type_id")
	private TypeOfOrphans typeOfOrphans;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_status_id")
	private ChildrenStatus childrenStatus;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "citizen_id")
    private CitizenIdentifications citizenId;

	public long getChildId() {
		return childId;
	}

//	public void setChildId(long childId) {
//		this.childId = childId;
//	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Persons getPersonChild() {
		return personChild;
	}

	public void setPersonChild(Persons personChild) {
		this.personChild = personChild;
	}

	public Images getImageChild() {
		return imageChild;
	}

	public void setImageChild(Images imageChild) {
		this.imageChild = imageChild;
	}

	public Employees getEmployeeChild() {
		return employeeChild;
	}

	public void setEmployeeChild(Employees employeeChild) {
		this.employeeChild = employeeChild;
	}

	public TypeOfOrphans getTypeOfOrphans() {
		return typeOfOrphans;
	}

	public void setTypeOfOrphans(TypeOfOrphans typeOfOrphans) {
		this.typeOfOrphans = typeOfOrphans;
	}

	public ChildrenStatus getChildrenStatus() {
		return childrenStatus;
	}

	public void setChildrenStatus(ChildrenStatus childrenStatus) {
		this.childrenStatus = childrenStatus;
	}

	public CitizenIdentifications getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(CitizenIdentifications citizenId) {
		this.citizenId = citizenId;
	}
	
	

	
	
	

}
