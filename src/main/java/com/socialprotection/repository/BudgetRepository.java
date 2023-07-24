package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
