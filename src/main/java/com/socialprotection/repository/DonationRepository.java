package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialprotection.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {
	@Query(value = "SELECT SUM(amount) FROM Donations", nativeQuery = true)
	Float getTotalAmount();
}
