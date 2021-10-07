package com.gd.horus.repo;

import java.util.Optional;

import com.gd.horus.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User, Long> {
    public Optional<User> findByUsername(String username);
}
