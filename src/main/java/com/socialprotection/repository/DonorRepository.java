package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor, Long> {

}
