package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
