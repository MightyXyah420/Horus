package com.gd.horus.repo;

import com.gd.horus.model.Form;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepo extends JpaRepository <Form, Long> {
    
}
