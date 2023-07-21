package com.socialprotection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Accounts;
import com.socialprotection.entity.AddressType;
import com.socialprotection.repository.AccountsRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountsRepository accountsRepository;
	
//	public void save(Accounts account) {
//		accountsRepository.save(account);
//	}

}
