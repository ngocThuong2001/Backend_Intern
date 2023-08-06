package com.socialprotection.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Guardian;
import com.socialprotection.repository.GuardianRepository;
import com.socialprotection.service.GuardianService;

@Service
public class GuardianServiceImpl implements GuardianService{
	@Autowired
	private GuardianRepository guardianRepository;

	@Override
	public Guardian save(Guardian guardian) {
		// TODO Auto-generated method stub
		return guardianRepository.save(guardian);
	}

	@Override
	public List<Guardian> getGuardians() {
		// TODO Auto-generated method stub
		return guardianRepository.findAll();
	}

	@Override
	public void deleteGuardian(Long id) {
		// TODO Auto-generated method stub
		guardianRepository.delete(id);
	}

}
