package com.socialprotection.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {

	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("access_token")
	private String token;
	public AuthenticationResponse(String userName, String token) {
		super();
		this.userName = userName;
		this.token = token;
	}



}
