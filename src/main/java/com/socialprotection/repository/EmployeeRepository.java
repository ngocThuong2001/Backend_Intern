package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Job;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{


//	@Query("SELECT e FROM employees e WHERE e.fullName like ?1", nativeQuery = true)
//	List<Employee> findByKeywords(String fullName);
	

	List<Employee> findByJob(Job job);

}
