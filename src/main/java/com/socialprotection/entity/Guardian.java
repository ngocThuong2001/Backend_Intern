package com.socialprotection.entity;

import java.sql.Date;

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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "guardians")
public class Guardian extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "guardian_id")
	private long guardianID;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",  timezone = "Asia/Ho_Chi_Minh")
	@Column(name = "birthday")
	private Date birthDay;

	@Column(name = "phone_number", columnDefinition = "Char(10)")
	private String phoneNumber;

	@Column(name = "email")
	private String email;

	@JsonIgnore
	@Transient
	@OneToOne(mappedBy = "guardian")
	private Children children;

	@Column(name = "relationship_type")
	private String relationshipType;

	public Guardian() {
		super();
	}

	public Guardian(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Date birthDay, String phoneNumber, String email,
			String relationshipType) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.birthDay = birthDay;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.relationshipType = relationshipType;
	}

	public Guardian(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, String phoneNumber, String email, Children children,
			String relationshipType) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.children = children;
		this.relationshipType = relationshipType;
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

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "Guardian [guardianID=" + guardianID + ", birthDay=" + birthDay + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", children=" + children + ", relationshipType=" + relationshipType + "]";
	}
	
}
