package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Adoption;
import com.socialprotection.service.AdoptionService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class AdoptionController {

	@Autowired
	private AdoptionService adoptionService;

	// create new adoption
	@PostMapping(value = "/adoption", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Adoption> createAdoption(@RequestBody Adoption adoption) {
		return ResponseEntity.ok(adoptionService.saveAdoption(adoption));
	}

	

	@GetMapping(value = "/getadoption", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Adoption> getAdoption() {
		return adoptionService.getAdoption();
	}

	// update adoption
	@PutMapping(value = "/adoption/{adoptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Adoption updateAdoption(@PathVariable Long adoptionId, @RequestBody Adoption adoption) {

		adoption.setAdoptionId(adoptionId);

		return adoptionService.updateAdoption(adoption);
	}

	@GetMapping(value = "/getadoption/{adoptionId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Adoption getAdoption(@PathVariable Long adoptionId) {

		Adoption adoption = adoptionService.getSingleAdoption(adoptionId);

		if (adoption == null) {
			ResponseEntity.notFound().build();
		}

		return adoption;
	}

	@DeleteMapping(value = "/deleteAdoption", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdoption(@RequestParam Long adoptionId) {
		adoptionService.deleteAdoption(adoptionId);
	}

}
