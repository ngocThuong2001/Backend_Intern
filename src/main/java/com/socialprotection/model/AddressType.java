package com.socialprotection.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_type")
public class AddressType {
	
	@Id
	@Column(name = "address_type_id")
	private int addressTypeId;
	
	private String name;
	
	public AddressType() {
		super();
	}

	public AddressType(int addressTypeId, String name) {
		super();
		this.addressTypeId = addressTypeId;
		this.name = name;
	}
	
	
}
