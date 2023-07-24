package com.socialprotection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.repository.ChildrenRepository;
import com.socialprotection.repository.ChildrenStatusRepository;
import com.socialprotection.repository.TypeOfOrphanRepopsitory;
import com.socialprotection.service.ChildrenService;

@Service
public class ChildrenServiceImpl implements ChildrenService{
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ChildrenStatusRepository childrenStatusRepository;
	
	@Autowired 
	private TypeOfOrphanRepopsitory typeOfOrphanRepopsitory;
}
