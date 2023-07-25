package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.AddressRepository;
import com.socialprotection.repository.AddressTypeRepository;
import com.socialprotection.service.AddressSevice;

@Service
public class AddressServiceImpl implements AddressSevice{
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressTypeRepository addressTypeRepository;
}
