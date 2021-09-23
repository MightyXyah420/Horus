package com.gd.horus.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Form form;

    @ElementCollection
    private List<String> questions=new ArrayList<String>();
}
