package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
