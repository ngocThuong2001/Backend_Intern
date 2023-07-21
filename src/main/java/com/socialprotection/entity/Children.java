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
    private Person personChild;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image imageChild;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employeeChild;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orphan_type_id")
	private TypeOfOrphan typeOfOrphans;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "child_status_id")
	private ChildrenStatus childrenStatus;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "citizen_id")
    private CitizenIdentification citizenId;

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

	public Person getPersonChild() {
		return personChild;
	}

	public void setPersonChild(Person personChild) {
		this.personChild = personChild;
	}

	public Image getImageChild() {
		return imageChild;
	}

	public void setImageChild(Image imageChild) {
		this.imageChild = imageChild;
	}

	public Employee getEmployeeChild() {
		return employeeChild;
	}

	public void setEmployeeChild(Employee employeeChild) {
		this.employeeChild = employeeChild;
	}

	public TypeOfOrphan getTypeOfOrphans() {
		return typeOfOrphans;
	}

	public void setTypeOfOrphans(TypeOfOrphan typeOfOrphans) {
		this.typeOfOrphans = typeOfOrphans;
	}

	public ChildrenStatus getChildrenStatus() {
		return childrenStatus;
	}

	public void setChildrenStatus(ChildrenStatus childrenStatus) {
		this.childrenStatus = childrenStatus;
	}

	public CitizenIdentification getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(CitizenIdentification citizenId) {
		this.citizenId = citizenId;
	}
	
	

	
	
	

}
