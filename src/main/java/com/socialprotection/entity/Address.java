package com.socialprotection.entity;

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

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private long addressId;

	@Column
	private String line;

	@Column
	private String ward;

	@Column
	private String distric;

	@Column
	private String country;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addressTypeId")
	private AddressType addresstype;
	

	public long getAddressId() {
		return addressId;
	}

//	public void setAddressId(long addressId) {
//		this.addressId = addressId;
//	}

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

	public String getDistric() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	public AddressType getAddresstype() {
		return addresstype;
	}



	public void setAddresstype(AddressType addresstype) {
		this.addresstype = addresstype;
	}



	
	
	

}
