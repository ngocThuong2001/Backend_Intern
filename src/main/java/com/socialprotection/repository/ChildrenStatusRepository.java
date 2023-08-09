package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.ChildrenStatus;
import java.util.List;


public interface ChildrenStatusRepository extends JpaRepository<ChildrenStatus, Long>{
	List<ChildrenStatus> findByStatus(String status);
}
