package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
