package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.AdopterRepository;
import com.socialprotection.service.AdopterService;

@Service
public class AdopterServiceImpl implements AdopterService{
	
	@Autowired
	private AdopterRepository adopterRepository;

}
