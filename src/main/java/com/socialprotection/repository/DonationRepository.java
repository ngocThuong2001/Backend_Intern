package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Donation;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
