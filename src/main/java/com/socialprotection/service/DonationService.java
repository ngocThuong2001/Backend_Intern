package com.socialprotection.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;

public interface DonationService {
	Donor saveDonor(Donor donor);

	Donation saveDonation(Donation donation);

	List<Donation> fndAll();

	Page<Donation> getDonationsPagin(Integer page, Integer limit, String sortBy, String sortDirec);
	
	Page<Donation> getDonationsByMonthInYear(Integer year, Integer month, Integer page, Integer limit, String sortBy, String sortDirec);
	
	Page<Donation> getDonationsByTime(Timestamp dateStart, Timestamp dateEnd, Integer page, Integer limit, String sortBy, String sortDirec);
	
	Page<Donation> getDonationsByDonorName(String name, Integer page, Integer limit, String sortBy, String sortDirec);

	Donation getDonationById(long id);

	float getTotalAmount();

	List<Donation> getDonationsByYear(Integer year);

	Float getDonationAmountByMonthInYear(Integer year, Integer month);

	List<BigDecimal> getMonthDonationAmountsByYear(Integer year);

	Map<Integer, BigDecimal> getYearsDonationAmounts();
	
	List<Integer> getAllYearsInDonation();
}
