package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long>{

}
