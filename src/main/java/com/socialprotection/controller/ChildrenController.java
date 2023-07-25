package com.socialprotection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.entity.Children;
import com.socialprotection.service.ChildrenService;

@RestController
@RequestMapping("/api/children")
public class ChildrenController {
	
	@Autowired
	private ChildrenService childrenService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Children>> getAllChildren() {
		return ResponseEntity.ok(childrenService.fildAll());
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Children> saveChildren(@RequestBody Children children) {
		return ResponseEntity.ok(childrenService.save(children));
	}
}