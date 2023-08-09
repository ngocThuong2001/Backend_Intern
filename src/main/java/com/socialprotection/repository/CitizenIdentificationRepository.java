package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialprotection.entity.CitizenIdentification;

@Repository
public interface CitizenIdentificationRepository extends JpaRepository<CitizenIdentification, Long>{

}
