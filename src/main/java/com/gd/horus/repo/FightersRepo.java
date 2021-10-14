package com.gd.horus.repo;

import java.util.Optional;

import com.gd.horus.model.Fighter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FightersRepo extends JpaRepository <Fighter, Long> {
    public Optional<Fighter> findByUsername (String username);
}
