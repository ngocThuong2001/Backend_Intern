package com.socialprotection.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
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
	private int child_id;
	
	private Date birthday;
	
	private char status;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Persons person_child;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Images image_child;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employees employee_child;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orphan_type_id")
	private TypeOfOrphans typeOfOrphans;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_status_id")
	private ChildrenStatus childrenStatus;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "citizen_id")
    private CitizenIdentifications citizenId;
	
	

	public CitizenIdentifications getCitizenId() {
		return citizenId;
	}


	public void setCitizenId(CitizenIdentifications citizenId) {
		this.citizenId = citizenId;
	}


	public ChildrenStatus getChildrenStatus() {
		return childrenStatus;
	}


	public void setChildrenStatus(ChildrenStatus childrenStatus) {
		this.childrenStatus = childrenStatus;
	}


	public int getChild_id() {
		return child_id;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public Persons getPerson_child() {
		return person_child;
	}

	public void setPerson_child(Persons person_child) {
		this.person_child = person_child;
	}

	public Images getImage_child() {
		return image_child;
	}

	public void setImage_child(Images image_child) {
		this.image_child = image_child;
	}

	public Employees getEmployee_child() {
		return employee_child;
	}

	public void setEmployee_child(Employees employee_child) {
		this.employee_child = employee_child;
	}

	public TypeOfOrphans getTypeOfOrphans() {
		return typeOfOrphans;
	}

	public void setTypeOfOrphans(TypeOfOrphans typeOfOrphans) {
		this.typeOfOrphans = typeOfOrphans;
	}
	
	

}
