package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.Employee;

public interface ChildrenRepository extends JpaRepository<Children, Long>{
	List<Children> findByEmployee(Employee employee);
	Page<Children> findByChildrenStatus(ChildrenStatus childrenStatus, Pageable pageable);
	long countByChildrenStatus(ChildrenStatus childrenStatus);
	
	@Query(value = "SELECT ch FROM Children ch WHERE fullName LIKE %?1% ")
	Page<Children> findByName(String name, Pageable pageable);
}
