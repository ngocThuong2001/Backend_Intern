package com.socialprotection.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialprotection.entity.Adoption;


public interface AdoptionRepository extends JpaRepository<Adoption, Long>{
	
	

}
