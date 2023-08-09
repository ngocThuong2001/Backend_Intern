package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.Employee;


public interface ChildrenRepository extends JpaRepository<Children, Long>{
	List<Children> findByEmployee(Employee employee);
	List<Children> findByChildrenStatus(ChildrenStatus childrenStatus);
	long countByChildrenStatus(ChildrenStatus childrenStatus);
}
