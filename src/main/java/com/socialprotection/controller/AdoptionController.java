package com.socialprotection.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Adopter;
import com.socialprotection.entity.Adoption;
import com.socialprotection.repository.AdopterRepository;
import com.socialprotection.utils.StatusResponse;

@RestController
@RequestMapping("/api")
public class AdoptionController {
	
	@Autowired
	private AdopterRepository adopterRepository;
	
	@PostMapping(value = "/adoptions", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusResponse> saveAdoption(Adoption adoption){
		return ResponseEntity.ok(new StatusResponse(true, "Oker"));
		
	}
	
	@PostMapping(value = "/adopters", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Adopter> createAdopter(@RequestBody Adopter adopter){
		return ResponseEntity.ok(adopter);
//		try {
//			
////			Adopter adopter2 = adopterRepository.save(adopter);
//			
//			return new ResponseEntity<>(adopter, HttpStatus.CREATED);
//			
//		} catch (Exception e) {
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
	}
	
//	@GetMapping("/adopters")
//	public ResponseEntity<List<Adopter>> getAllAdopters(@RequestParam(required = false) String email){
//		
//		try {
//			
//			List<Adopter> adopters = new ArrayList<Adopter>();
//			
//			if (email == null) {
//				adopterRepository.findAll().forEach(adopters::add);
//			}
//			else {
//				adopterRepository.findByEmailContaining(email).forEach(adopters::add);
//			}
//			
//			return new ResponseEntity<>(adopters, HttpStatus.OK);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		return null;
//		
//	}
	
	
	
}
