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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Donors")
@Table(name = "donors")
public class Donor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donor_id")
	private long donorId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "Asia/Ho_Chi_Minh")
	@Column(name = "birthday")
	private Date birthDay;

	@Column(name = "phone_number", columnDefinition = "char(10)")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@JsonIgnore
	@OneToOne(mappedBy = "donor", fetch = FetchType.LAZY)
	private Donation donation;

	public long getDonorId() {
		return donorId;
	}

	public void setDonorId(long donorId) {
		this.donorId = donorId;
	}

	public Donor() {
		super();
	}

	public Donor(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Date birthDay, String phoneNumber, String email,
			Donation donation) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.donation = donation;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
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

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", donation=" + donation + "]";
	}

}
