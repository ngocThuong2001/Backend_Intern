package com.socialprotection.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
