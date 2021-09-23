package com.gd.horus.repo;

import com.gd.horus.model.Battle;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepo extends JpaRepository <Battle, Long> {
    
}
