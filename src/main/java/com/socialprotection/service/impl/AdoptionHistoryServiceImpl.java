package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.AdoptionHistoryRepository;
import com.socialprotection.service.AdoptionHistoryService;

@Service
public class AdoptionHistoryServiceImpl implements AdoptionHistoryService{
	
	@Autowired
	private AdoptionHistoryRepository adoptionHistoryRepository;

}
