package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Adoption;
import com.socialprotection.repository.AdoptionRepository;
import com.socialprotection.utils.StatusResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AdoptionController {
	
	@Autowired
	private AdoptionRepository adoptionRepository;
	
//	@PostMapping(value = "/adoptions", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<StatusResponse> saveAdoption(Adoption adoption){
//		return ResponseEntity.ok(new StatusResponse(true, "Oker"));
//		
//	}
	
	//create new adoption
	@PostMapping(value = "/adoption", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Adoption> createAdoption(@RequestBody Adoption adoption) {
//		return adoptionRepository.save(adoption);
		return ResponseEntity.ok(adoption);
	}
	

	
	
	
}
