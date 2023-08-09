package com.socialprotection.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Guardian;
import com.socialprotection.service.GuardianService;

@CrossOrigin
@RestController
@RequestMapping("/api/guardians")
public class GuardianController {
	
	@Autowired
	private GuardianService guardianService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Guardian> saveGuardian(@RequestBody Guardian guardian) {
		return ResponseEntity.ok(guardianService.save(guardian));
	}
	
	@GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Guardian> guardians(){
		return guardianService.getGuardians();
	}
	
	@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
		public void deleteeGuardian(@RequestParam Long guardianID) {
			guardianService.deleteGuardian(guardianID);
		}
	
}
