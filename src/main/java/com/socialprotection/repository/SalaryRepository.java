package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Salary;

public interface SalaryRepository extends JpaRepository<Salary, Long>{

}
