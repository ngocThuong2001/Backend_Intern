package com.socialprotection.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialprotection.entity.Adopter;
import com.socialprotection.entity.Adoption;
import com.socialprotection.repository.AdopterRepository;
import com.socialprotection.repository.AdoptionRepository;
import com.socialprotection.repository.CitizenIdentificationRepository;
import com.socialprotection.service.AdoptionService;

@Service
public class AdoptionServiceImpl implements AdoptionService {

	@Autowired
	private AdopterRepository adopterRepository;

	@Autowired
	private AdoptionRepository adoptionRepository;

	@Autowired
	private CitizenIdentificationRepository citizenIdentificationRepository;

	@Override
	public Adoption saveAdoption(Adoption adoption) {

//		adoption.getAdopters().forEach(pl -> pl.setAdoption(adoption)); 

		Adoption adoption2 = adoptionRepository.save(adoption);

		return adoption2;
	}

	@Override
	public Adoption updateAdoption(Adoption adoption) {
		// TODO Auto-generated method stub
		
		
		
		return adoptionRepository.save(adoption);
	}

	@Override
	public List<Adoption> getAdoption() {
		// TODO Auto-generated method stub

		return adoptionRepository.findAll();
	}

	@Override
	public Adoption getSingleAdoption(Long adoptionId) {
		
		Adoption adoption = adoptionRepository.findOne(adoptionId);
		
		return adoption;
		
		
	}

	@Override
	public void deleteAdoption(Long adoptionId) {
		adoptionRepository.delete(adoptionId);
	}

//	@Override
//	public List<Adopter> searchAdoption(String query) {
//		List<Adopter> adoptions = adopterRepository.searchAdoption(query);
//		return adoptions;
//	}
//
//	@Override
//	public List<Adopter> searchName(String name) {
//		List<Adopter> adopters = adopterRepository.searchName(name);
//		return adopters;
//	}


	
	

}
