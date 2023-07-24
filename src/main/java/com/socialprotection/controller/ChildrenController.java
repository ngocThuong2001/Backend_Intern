package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Children> saveChildren(@RequestBody Children children) {
		childrenService.save(children);
		return ResponseEntity.ok(children);
	}
}
