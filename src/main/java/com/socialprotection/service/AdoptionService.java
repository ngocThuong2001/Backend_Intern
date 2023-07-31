package com.socialprotection.service;

import java.util.List;

import com.socialprotection.entity.Adopter;
import com.socialprotection.entity.Adoption;

public interface AdoptionService {
	
	public Adoption saveAdoption(Adoption adoption);
	
	public List<Adoption> getAdoption();
	
	public Adoption updateAdoption(Adoption adoption);
	
	public Adoption getSingleAdoption(Long adoptionId);
	
	public void deleteAdoption(Long adoptionId);
	
//	List<Adopter> searchAdoption(String query);
//	
//	List<Adopter> searchName(String name);

}
