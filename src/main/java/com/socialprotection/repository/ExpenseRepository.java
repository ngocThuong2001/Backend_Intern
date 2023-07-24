package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
