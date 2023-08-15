package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Job;
import java.util.List;


public interface JobRepository extends JpaRepository<Job, Long>{
	List<Job> findByJobTitle(String jobTitle);
}
