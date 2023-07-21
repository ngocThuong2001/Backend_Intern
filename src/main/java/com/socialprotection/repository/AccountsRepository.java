package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialprotection.entity.Accounts;


public interface AccountsRepository extends JpaRepository<Accounts, Integer>{

}
