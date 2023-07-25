package com.socialprotection.entity;

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
@Table(name = "guardians")
public class Guardian extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guardian_id")
	private long guardianID;

	@Column(name = "phone_number", columnDefinition = "Char(10)")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "child_id")
	private Children children;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getGuardianID() {
		return guardianID;
	}

	public void setGuardianID(long guardianID) {
		this.guardianID = guardianID;
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

	public Children getChildren() {
		return children;
	}

	public void setChildren(Children children) {
		this.children = children;
	}

	public Guardian(String fullName, String firstName, String lastName, String gender, String nationality,
			String phoneNumber, String email) {
		super(fullName, firstName, lastName, gender, nationality);
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Guardian() {
		super();
	}

}
