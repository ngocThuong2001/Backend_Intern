package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialprotection.entity.Adopter;

@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long>{
	
	@Query("SELECT a FROM Adopter a WHERE " +
            "a.fullName LIKE CONCAT('%',:query, '%')" +
            "Or a.firstName LIKE CONCAT('%', :query, '%')")
    List<Adopter> searchAdoption(String query);
	
	

}
