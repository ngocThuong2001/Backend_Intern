package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;
import com.socialprotection.repository.DonationRepository;
import com.socialprotection.repository.DonorRepository;
import com.socialprotection.service.DonationService;

@Service	
public class DonationServiceImpl implements DonationService{
	
	@Autowired
	private DonationRepository donationRepository;
	
	@Autowired
	private DonorRepository donorRepository;

	@Override
	public Donor saveDonor(Donor donor) {
		// TODO Auto-generated method stub
		return donorRepository.save(donor);
	}

	@Override
	public Donation saveDonation(Donation donation) {
		// TODO Auto-generated method stub
		return donationRepository.save(donation);
	}

	@Override
	public Donation getDonationById(long id) {
		// TODO Auto-generated method stub
		return donationRepository.findOne(id);
	}

	@Override
	public List<Donation> fndAll() {
		// TODO Auto-generated method stub
		return donationRepository.findAll();
	}

	@Override
	public float getTotalAmount() {
		// TODO Auto-generated method stub
		return donationRepository.getTotalAmount();
	}

}
