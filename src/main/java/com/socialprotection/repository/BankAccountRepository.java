package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

}
