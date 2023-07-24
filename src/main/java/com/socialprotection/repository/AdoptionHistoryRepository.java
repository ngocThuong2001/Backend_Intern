package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.AdoptionHistory;

public interface AdoptionHistoryRepository extends JpaRepository<AdoptionHistory, Long>{

}
