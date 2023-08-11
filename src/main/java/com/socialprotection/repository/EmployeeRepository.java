package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.Employee;
import com.socialprotection.entity.Person;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	@Query("SELECT e FROM employees e WHERE e.fullName = :fullName")
//	List<Employee> findByFullname(@Param("fullName") String fullName);
	
}
