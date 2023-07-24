package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {

}
