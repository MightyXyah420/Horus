package com.gd.horus.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gd.horus.model.ScoreCard;

public interface ScoreCardRepo extends JpaRepository <ScoreCard, Long> {
    
}
