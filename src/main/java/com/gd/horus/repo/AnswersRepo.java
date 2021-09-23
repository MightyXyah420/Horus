package com.gd.horus.repo;

import com.gd.horus.model.Answers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswersRepo extends JpaRepository <Answers, Long> {
    
}
