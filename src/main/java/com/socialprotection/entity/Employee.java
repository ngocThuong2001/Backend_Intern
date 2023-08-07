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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "phone_number", columnDefinition = "char(10)")
	private String phoneNumber;

	private String email;

	@Column(name = "salary")
	private float salary;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "birthday")
	private Date birthDay;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "from_date")
	private Date fromDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "to_date")
	private Date toDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id")
	private Job job;

	@JsonIgnore
	@OneToMany(mappedBy = "employee")
	private List<Children> children;

	@JsonIgnore
	@OneToOne(mappedBy = "empAct")
	private Activity activity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shift_id")
	private Shift shift;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "citizen_id")
	private CitizenIdentification citizenId;

	public Employee(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Image image, String phoneNumber, String email,
			float salary, Date birthDay, Date fromDate, Date toDate, Job job, Shift shift) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.image = image;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.salary = salary;
		this.birthDay = birthDay;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.job = job;
		this.shift = shift;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
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

	public CitizenIdentification getCitizenId() {
		return citizenId;
	}

	public void setCitizenId(CitizenIdentification citizenId) {
		this.citizenId = citizenId;
	}
	
	
}
