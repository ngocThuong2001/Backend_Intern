package com.socialprotection.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialprotection.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
	@Query(value = "SELECT SUM(amount) FROM Donations", nativeQuery = true)

	Float getTotalAmount();

	//float getTotalAmount();
	
	@Query(value = "SELECT * FROM Donations WHERE EXTRACT(year FROM donate_time) = ?1", nativeQuery = true)
	List<Donation> getDonationByYear(Integer year);
	
	@Query(value = "SELECT SUM(amount) FROM Donations WHERE EXTRACT(year FROM donate_time) = ?1", nativeQuery = true)
	Float getDonationAmountByYear(Integer year);
	
	@Query(value = "SELECT EXTRACT(year FROM donate_time) FROM Donations GROUP BY EXTRACT(year FROM donate_time)", nativeQuery = true)
	List<Integer> getAllYearsInDonation();
	
	@Query(value = "SELECT SUM(amount) FROM Donations WHERE EXTRACT(year FROM donate_time) = ?1 AND EXTRACT(month FROM donate_time) = ?2", nativeQuery = true)
	Float getDonationAmountByMonthInYear(Integer year, Integer month);
	
	@Query(value = "SELECT dt FROM Donations dt INNER JOIN Donors dn ON dt.donor.donorId = dn.donorId WHERE dn.fullName LIKE %?1% ")
	Page<Donation> getDonationsByDonorName(String name, Pageable pageable);
	
	@Query(value = "SELECT dt FROM Donations dt WHERE EXTRACT(year FROM donate_time) = ?1 AND EXTRACT(month FROM donate_time) = ?2")
	Page<Donation> getDonationsByMonthInYear(Integer year, Integer month, Pageable pageable);
	
	@Query(value = "SELECT dt FROM Donations dt WHERE donate_time BETWEEN ?1 AND ?2")
	Page<Donation> getDonationsByTime(Timestamp dateStart, Timestamp dateEnd, Pageable pageable);

}
