package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialprotection.auth.RegisterRequest;
import com.socialprotection.service.UserService;
import com.socialprotection.utils.StatusResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StatusResponse> saveUser(RegisterRequest registerRequest){
//		return
		return  ResponseEntity.ok(userService.saveUser(registerRequest));
	}
}
