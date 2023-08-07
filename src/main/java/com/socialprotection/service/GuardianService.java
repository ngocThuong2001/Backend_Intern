package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Guardian;

public interface GuardianService {
	public Guardian save(Guardian guardian);
	
	public List<Guardian> getGuardians();
	
	public void deleteGuardian(Long id);
}
