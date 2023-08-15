package com.socialprotection.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Donation;
import com.socialprotection.entity.Donor;
import com.socialprotection.repository.DonationRepository;
import com.socialprotection.repository.DonorRepository;
import com.socialprotection.service.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;

	@Autowired
	private DonorRepository donorRepository;

	@Override
	public Donor saveDonor(Donor donor) {
		return donorRepository.save(donor);
	}

	@Override
	public Donation saveDonation(Donation donation) {
		return donationRepository.save(donation);
	}

	@Override
	public Donation getDonationById(long id) {
		return donationRepository.findOne(id);
	}

	@Override
	public List<Donation> fndAll() {
		return donationRepository.findAll();
	}

	@Override
	public float getTotalAmount() {
<<<<<<< HEAD
		// TODO Auto-generated method stub
		if (donationRepository.getTotalAmount() == null) {
			return 0;
		}
=======
>>>>>>> branch 'master' of https://github.com/Nbtrien/social-protection-center-api.git
		return donationRepository.getTotalAmount();
	}

	@Override
	public Page<Donation> getDonationsPagin(Integer page, Integer limit, String sortBy, String sortDirec) {
		Pageable pageable = null;
		Sort sortDesc = null;
		if (limit != null && page != null) {
			if (sortBy != null && sortDirec != null) {
				sortDesc = new Sort(Sort.Direction.fromString(sortDirec), sortBy);
			}
			pageable = new PageRequest(page, limit, sortDesc);
		}
		return donationRepository.findAll(pageable);
	}

	@Override
	public Page<Donation> getDonationsByMonthInYear(Integer year, Integer month, Integer page, Integer limit,
			String sortBy, String sortDirec) {
		Pageable pageable = null;
		Sort sortDesc = null;
		if (limit != null && page != null) {
			if (sortBy != null && sortDirec != null) {
				sortDesc = new Sort(Sort.Direction.fromString(sortDirec), sortBy);
			}
			pageable = new PageRequest(page, limit, sortDesc);
		}
		return donationRepository.getDonationsByMonthInYear(year, month, pageable);
	}

	@Override
	public Page<Donation> getDonationsByDonorName(String name, Integer page, Integer limit, String sortBy,
			String sortDirec) {
		Pageable pageable = null;
		Sort sortDesc = null;
		if (limit != null && page != null) {
			if (sortBy != null && sortDirec != null) {
				sortDesc = new Sort(Sort.Direction.fromString(sortDirec), sortBy);
			}
			pageable = new PageRequest(page, limit, sortDesc);
		}
		return donationRepository.getDonationsByDonorName(name, pageable);
	}
	

	@Override
	public Page<Donation> getDonationsByTime(Timestamp dateStart, Timestamp dateEnd, Integer page, Integer limit,
			String sortBy, String sortDirec) {
		Pageable pageable = null;
		Sort sortDesc = null;
		if (limit != null && page != null) {
			if (sortBy != null && sortDirec != null) {
				sortDesc = new Sort(Sort.Direction.fromString(sortDirec), sortBy);
			}
			pageable = new PageRequest(page, limit, sortDesc);
		}
		return donationRepository.getDonationsByTime(dateStart, dateEnd, pageable);
	}

	@Override
	public List<Donation> getDonationsByYear(Integer year) {
		return donationRepository.getDonationByYear(year);
	}

	@Override
	public Float getDonationAmountByMonthInYear(Integer year, Integer month) {
		return donationRepository.getDonationAmountByMonthInYear(year, month);
	}

	@Override
	public List<BigDecimal> getMonthDonationAmountsByYear(Integer year) {
		List<BigDecimal> amounts = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			Float amount = donationRepository.getDonationAmountByMonthInYear(year, i);
			if (amount != null) {
				amounts.add(new BigDecimal(amount));
			} else {
				amounts.add(null);
			}

		}
		return amounts;
	}

	@Override
	public Map<Integer, BigDecimal> getYearsDonationAmounts() {
		List<Integer> years = donationRepository.getAllYearsInDonation();
		Map<Integer, BigDecimal> yearsDonationAmounts = new TreeMap<Integer, BigDecimal>();
		for (Integer year : years) {
			Float amount = donationRepository.getDonationAmountByYear(year);
			yearsDonationAmounts.put(year, new BigDecimal(amount));
		}
		return yearsDonationAmounts;
	}

	@Override
	public List<Integer> getAllYearsInDonation() {
		return donationRepository.getAllYearsInDonation();
	}


}
