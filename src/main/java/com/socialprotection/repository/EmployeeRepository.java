package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
