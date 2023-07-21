package com.socialprotection.auth;

import com.socialprotection.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	  private String userName;
	  private String passWord;
	  private Role role;
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public Role getRole() {
		return role;
	}
	  
	  
}
