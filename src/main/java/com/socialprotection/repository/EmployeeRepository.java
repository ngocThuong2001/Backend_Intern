package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.socialprotection.entity.Employee;
<<<<<<< HEAD
import com.socialprotection.entity.Person;
=======
import com.socialprotection.entity.Job;
>>>>>>> branch 'master' of https://github.com/Nbtrien/social-protection-center-api.git

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
<<<<<<< HEAD

//	@Query("SELECT e FROM employees e WHERE e.fullName like ?1", nativeQuery = true)
//	List<Employee> findByKeywords(String fullName);
	
=======
	List<Employee> findByJob(Job job);
>>>>>>> branch 'master' of https://github.com/Nbtrien/social-protection-center-api.git
}
