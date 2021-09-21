package com.gd.horus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Battle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User FighterA;
    
    @ManyToOne
    private User FighterB;

    @ManyToOne
    private ScoreCard score;

    private String winner;
    
}
