package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.BankAccountRepository;
import com.socialprotection.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountRepository bankAccountRepository;
}
