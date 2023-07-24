package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
