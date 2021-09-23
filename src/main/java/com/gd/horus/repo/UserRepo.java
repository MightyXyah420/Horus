package com.gd.horus.repo;

import com.gd.horus.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
    
}
