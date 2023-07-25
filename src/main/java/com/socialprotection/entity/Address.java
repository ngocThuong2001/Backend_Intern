package com.socialprotection.entity;

import java.sql.Date;
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
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long addressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_type_id")
	private AddressType addressType;

	private String line;
	private String ward;
	private String district;
	private String city;

	@CreatedDate
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "modified_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date modifiedAt;

	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Guardian> guardians;

	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Children> childrens;

	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Employee> employees;

	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Donor> donors;

	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Adopter> adopters;

	public List<Guardian> getGuardians() {
		return guardians;
	}

	public void setGuardians(List<Guardian> guardians) {
		this.guardians = guardians;
	}

	public List<Children> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Children> childrens) {
		this.childrens = childrens;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Donor> getDonors() {
		return donors;
	}

	public void setDonors(List<Donor> donors) {
		this.donors = donors;
	}

	public List<Adopter> getAdopters() {
		return adopters;
	}

	public void setAdopters(List<Adopter> adopters) {
		this.adopters = adopters;
	}

	public Address() {
		super();
	}

	public Address(long addressId, AddressType addressType, String line, String ward, String district, String city) {
		super();
		this.addressId = addressId;
		this.addressType = addressType;
		this.line = line;
		this.ward = ward;
		this.district = district;
		this.city = city;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}