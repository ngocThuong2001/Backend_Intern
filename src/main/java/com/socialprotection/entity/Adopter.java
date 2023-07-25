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
@Table(name = "adopters")
public class Adopter extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adopter_id")
	private long adopterId;

	@Column(name = "bithday")
	private Date bithday;

	@Column(name = "phone_number")
	private char phoneNumber;

	@Column(name = "email")
	private String email;

	@Column(name = "nation")
	private String nation;

	@Column(name = "accupation")
	private String occupation;

	@Column(name = "income")
	private float income;

	@Column(name = "relationship")
	private String relationship;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "citizen_ident_id")
	private CitizenIdentification citizenIdentification;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adoption_id")
	private Adoption adoption;

	@OneToMany(mappedBy = "adopter")
	private List<AdoptionHistory> adoptionHistory;

	

	public void setAdopterId(long adopterId) {
		this.adopterId = adopterId;
	}

	public List<AdoptionHistory> getAdoptionHistory() {
		return adoptionHistory;
	}

	public void setAdoptionHistory(List<AdoptionHistory> adoptionHistory) {
		this.adoptionHistory = adoptionHistory;
	}

	

	public Adoption getAdoption() {
		return adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}

	public long getAdopterId() {
		return adopterId;
	}

//	public void setAdopterId(long adopterId) {
//		this.adopterId = adopterId;
//	}

	public Date getBithday() {
		return bithday;
	}

	public void setBithday(Date bithday) {
		this.bithday = bithday;
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

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public CitizenIdentification getCitizenIdentification() {
		return citizenIdentification;
	}

	public void setCitizenIdentification(CitizenIdentification citizenIdentification) {
		this.citizenIdentification = citizenIdentification;
	}

	

	public Adopter(String fullName, String firstName, String lastName, String gender, String nationality,
			String addressPermanent, String addressTemporary, Date bithday, char phoneNumber, String email,
			String nation, String occupation, float income, String relationship) {
		super(fullName, firstName, lastName, gender, nationality, addressPermanent, addressTemporary);
		this.bithday = bithday;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.nation = nation;
		this.occupation = occupation;
		this.income = income;
		this.relationship = relationship;
	}

	public Adopter() {
		super();
	}

}