package com.gd.horus.repo;

import com.gd.horus.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository <Role, Long> {
    
}
