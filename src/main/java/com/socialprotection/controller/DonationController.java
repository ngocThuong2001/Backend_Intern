package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Donor;
import com.socialprotection.service.DonationService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DonationController {
	@Autowired
	private DonationService donationService;
	
	@PostMapping(value = "/donations/{amount}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Donor> receiveDonor(@RequestBody Donor donor, @PathVariable Float amount) {
//		System.out.println(request.getParameterNames().nextElement().toString());
		System.out.println(donor.toString());
		System.out.println(amount);
		return ResponseEntity.ok(donationService.saveDonor(donor)); 
	}
}
