package com.socialprotection.service;

import com.socialprotection.auth.RegisterRequest;
import com.socialprotection.entity.Role;
import com.socialprotection.entity.User;
import com.socialprotection.utils.StatusResponse;

public interface UserService {
	public User saveUser(User user);
	public StatusResponse saveUser(RegisterRequest registerRequest);
	public Role saveRole(Role role);
}
