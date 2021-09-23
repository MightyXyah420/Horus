package com.gd.horus.repo;

import com.gd.horus.model.Insurance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepo extends JpaRepository <Insurance, Long> {
    
}
