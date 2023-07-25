package com.socialprotection.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "employees")
public class Employee extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long employeeId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private Image image;

	@Column(name = "phone_number")
	private char phoneNumber;

	private String email;

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_id")
	private Job job;
	
	

	@OneToMany(mappedBy = "employee")
	private List<Children> children;

	@OneToMany(mappedBy = "empSalary")
	private List<Salary> salaries;

	@OneToOne(mappedBy = "empAct")
	private Activity activity;

	@OneToMany(mappedBy = "employee")
	private List<Shift> shift;

	

	public List<Shift> getShift() {
		return shift;
	}

	public void setShift(List<Shift> shift) {
		this.shift = shift;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public Image getImage() {
		return image;
	}

	public void setImages(Image image) {
		this.image = image;
	}

	public char getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(char phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
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

	

	public Employee(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, char phoneNumber, String email, Date fromDate,
			Date toDate) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public Employee() {
		super();
	}

}
