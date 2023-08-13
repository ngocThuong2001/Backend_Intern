package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Job;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByJob(Job job);
}
