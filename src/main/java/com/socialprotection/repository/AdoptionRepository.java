package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Adoption;

public interface AdoptionRepository extends JpaRepository<Adoption, Long>{

}
