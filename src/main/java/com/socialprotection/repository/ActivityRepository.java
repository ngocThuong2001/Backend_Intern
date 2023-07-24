package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
