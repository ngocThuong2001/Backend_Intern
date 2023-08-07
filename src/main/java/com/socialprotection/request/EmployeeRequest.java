package com.socialprotection.request;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.socialprotection.entity.Job;
import com.socialprotection.entity.Shift;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private String phoneNumber;
	private String nationality;
	private String addressPermanent;
	private String addressTemporary;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date birthDay;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date fromDate;
	private Job job;
	private Shift shift;
	private String salary;
	public EmployeeRequest(String firstName, String lastName, String gender, String email, String phoneNumber,
			String nationality, String addressPermanent, String addressTemporary, Date birthDay, Date fromDate, Job job,
			Shift shift, String salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.nationality = nationality;
		this.addressPermanent = addressPermanent;
		this.addressTemporary = addressTemporary;
		this.birthDay = birthDay;
		this.fromDate = fromDate;
		this.job = job;
		this.shift = shift;
		this.salary = salary;
	}
	public EmployeeRequest() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getAddressPermanent() {
		return addressPermanent;
	}
	public void setAddressPermanent(String addressPermanent) {
		this.addressPermanent = addressPermanent;
	}
	public String getAddressTemporary() {
		return addressTemporary;
	}
	public void setAddressTemporary(String addressTemporary) {
		this.addressTemporary = addressTemporary;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Shift getShift() {
		return shift;
	}
	public void setShift(Shift shift) {
		this.shift = shift;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeRequest [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", nationality=" + nationality + ", addressPermanent="
				+ addressPermanent + ", addressTemporary=" + addressTemporary + ", birthDay=" + birthDay + ", fromDate="
				+ fromDate + ", job=" + job + ", shift=" + shift + ", salary=" + salary + "]";
	}
	
	
}
