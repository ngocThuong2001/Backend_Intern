package com.socialprotection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.model.AddressType;
import com.socialprotection.repository.AddressTypeRepository;

@Service
public class AddressTypeService {
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	
	public void save(AddressType addressType) {
		addressTypeRepository.save(addressType);
	}
}
