package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.DonationRepository;
import com.socialprotection.repository.DonorRepository;
import com.socialprotection.service.DonationService;

@Service	
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private DonorRepository donorRepository;

}
