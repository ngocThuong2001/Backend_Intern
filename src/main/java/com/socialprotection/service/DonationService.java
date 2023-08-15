package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;

public interface DonationService {
	Donor saveDonor(Donor donor);
	Donation saveDonation(Donation donation);
	List<Donation> fndAll();
	Donation getDonationById(long id);
	float getTotalAmount();
}
