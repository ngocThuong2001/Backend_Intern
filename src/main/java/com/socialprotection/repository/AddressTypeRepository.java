package com.socialprotection.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialprotection.entity.AddressType;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Integer>{

}
