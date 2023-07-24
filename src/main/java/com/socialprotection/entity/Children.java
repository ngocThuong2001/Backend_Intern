package com.socialprotection.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Image image;

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

	@OneToMany(mappedBy = "child")
	private List<MedicalRecord> medicalRecords;

	@Column(name = "date_in")
	private Date dateIn;

	@Column(name = "date_out")
	private Date dateOut;

	public long getChildId() {
		return childId;
	}

	public void setChildId(long childId) {
		this.childId = childId;
	}

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

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public Date getDateIn() {
		return dateIn;
	}

	public void setDateIn(Date dateIn) {
		this.dateIn = dateIn;
	}

	public Date getDateOut() {
		return dateOut;
	}

	public void setDateOut(Date dateOut) {
		this.dateOut = dateOut;
	}

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}