package com.socialprotection.service;

import com.socialprotection.entity.Role;
import com.socialprotection.entity.User;

public interface UserService {
	public User saveUser(User user);

	public Role saveRole(Role role);
}
