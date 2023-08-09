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

@Entity
@Table(name = "donors")
public class Donor extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donor_id")
	private long donorId;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name = "birthday")
	private Date birthDay;

	@Column(name = "phone_number", columnDefinition = "char(10)")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	@Column(name = "account_name")
	private String accountName;

	@Column(name = "account_number")
	private String accountNumber;

	@Column(name = "bank_name")
	private String bankName;

	@Column(name = "bank_cvv")
	private String bankCvv;

	@Column(name = "expiration_date")
	private Date expirationDate;

	@OneToOne(mappedBy = "donor")
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

	public Donor(String accountName, String accountNumber, String bankName, String bankCvv, Date expirationDate,
			Donation donation) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankCvv = bankCvv;
		this.expirationDate = expirationDate;
		this.donation = donation;
	}
	
	

	public Donor(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Date birthDay, String phoneNumber, String email,
			String accountName, String accountNumber, String bankName, String bankCvv, Date expirationDate,
			Donation donation) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankCvv = bankCvv;
		this.expirationDate = expirationDate;
		this.donation = donation;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCvv() {
		return bankCvv;
	}

	public void setBankCvv(String bankCvv) {
		this.bankCvv = bankCvv;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	@Override
	public String toString() {
		return super.toString()+" Donor [donorId=" + donorId + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", accountName=" + accountName + ", accountNumber=" + accountNumber + ", bankName=" + bankName
				+ ", bankCvv=" + bankCvv + ", expirationDate=" + expirationDate + ", donation=" + donation + "]";
	}

	
}
