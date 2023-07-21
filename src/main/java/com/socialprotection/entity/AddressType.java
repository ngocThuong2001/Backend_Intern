package com.socialprotection.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="address_type")
public class AddressType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_type_id")
	private long addressTypeId;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "addresstype")
    private List<Address> address = new ArrayList<>();
	
	public long getAddressTypeId() {
		return addressTypeId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	public List<Address> getAddress() {
		return address;
	}


	public void setAddress(List<Address> address) {
		this.address = address;
	}


	
	
	
	
	
}
