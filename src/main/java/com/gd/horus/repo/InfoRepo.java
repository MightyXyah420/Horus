package com.gd.horus.repo;

import java.util.Optional;

import com.gd.horus.model.FighterInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepo extends JpaRepository <FighterInfo, Long> {
    public FighterInfo findByDoc(String doc);
}
