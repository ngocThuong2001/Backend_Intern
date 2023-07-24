package com.socialprotection.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Children;
import com.socialprotection.entity.ChildrenStatus;
import com.socialprotection.entity.TypeOfOrphan;
import com.socialprotection.repository.ChildrenRepository;
import com.socialprotection.repository.ChildrenStatusRepository;
import com.socialprotection.repository.PersonRepository;
import com.socialprotection.repository.TypeOfOrphanRepopsitory;
import com.socialprotection.service.ChildrenService;

@Service
public class ChildrenServiceImpl implements ChildrenService{
	@Autowired
	private ChildrenRepository childrenRepository;
	
	@Autowired
	private ChildrenStatusRepository childrenStatusRepository;
	
	@Autowired 
	private PersonRepository personRepository;
	
	@Autowired 
	private TypeOfOrphanRepopsitory typeOfOrphanRepopsitory;

	@Override
	@Transactional
	public Children save(Children children) {
//		 TODO Auto-generated method stub
		personRepository.save(children.getPerson());
		return childrenRepository.save(children);
	}

	@Override
	public TypeOfOrphan saveTypeOrphan(TypeOfOrphan typeOfOrphan) {
		// TODO Auto-generated method stub
		return typeOfOrphanRepopsitory.save(typeOfOrphan);
	}

	@Override
	public ChildrenStatus saveChildrenStatus(ChildrenStatus childrenStatus) {
		// TODO Auto-generated method stub
		return childrenStatusRepository.save(childrenStatus);
	}
}
