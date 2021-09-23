package com.gd.horus.repo;

import com.gd.horus.model.Sugestion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestionRepo extends JpaRepository <Sugestion, Long>{
    
}
