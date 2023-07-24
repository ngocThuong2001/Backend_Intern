package com.socialprotection.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class AuthenticationResponse {

	@JsonProperty("user_name")
	private String userName;
	@JsonProperty("access_token")
	private String token;
	@JsonProperty("role")
	private String role;

	public AuthenticationResponse(String userName, String token) {
		super();
		this.userName = userName;
		this.token = token;
	}

	public AuthenticationResponse(String userName, String token, String role) {
		super();
		this.userName = userName;
		this.token = token;
		this.role = role;
	}

}
