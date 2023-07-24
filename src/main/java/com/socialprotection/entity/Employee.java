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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private long employeeId;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "person_id")
	private Person person;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "image_id")
	private Image images;

	@Column(name = "phone_number")
	private char phoneNumber;

	private String email;

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	@OneToMany(mappedBy = "employees")
	private List<Job> jobs = new ArrayList<>();

	@OneToMany(mappedBy = "employeeChild")
	private List<Children> children = new ArrayList<>();
	
	@OneToMany(mappedBy = "empSalary")
	private List<Salary> salaries = new ArrayList<Salary>();
	
	@OneToOne(mappedBy = "empAct")
	private Activity activity;
	
	
	@OneToMany(mappedBy = "employee")
	private List<Shift> shift = new ArrayList<>();
	
	
	
	
	

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

//	public void setEmployeeId(long employeeId) {
//		this.employeeId = employeeId;
//	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Image getImages() {
		return images;
	}

	public void setImages(Image images) {
		this.images = images;
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

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Children> getChildren() {
		return children;
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

	public Employee(Person person, Image images, char phoneNumber, String email, Date fromDate, Date toDate,
			List<Job> jobs, List<Children> children, List<Salary> salaries, Activity activity, List<Shift> shift) {
		super();
		this.person = person;
		this.images = images;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.jobs = jobs;
		this.children = children;
		this.salaries = salaries;
		this.activity = activity;
		this.shift = shift;
	}

	public Employee() {
		super();
	}

	
	
	
}
