package com.gd.horus.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Fighter extends User {
    
    @OneToOne
    private FighterInfo data;
}
