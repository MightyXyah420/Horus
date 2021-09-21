package com.gd.horus.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import com.gd.horus.util.Doc;

@Entity
public class FighterInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String fullName;

    @Column
    private String doc;

    @Enumerated(EnumType.ORDINAL)
    private Doc status;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String addr;

    @Column
    private String rh;

    @Column
    private String contact;

    @ElementCollection
    @MapKeyColumn(name="house")
    @Column(name="trainings")
    @CollectionTable(name="house_trainings", joinColumns=@JoinColumn(name="keep_up_MF"))
    private Map <String, Integer> trainings = new HashMap<String, Integer>();

    @ManyToOne
    private Insurance insurance; 

    @Column
    private int faults;
    
    @Column
    private int sessions;

    @Column
    private int wars;

    @Column
    private int elo;

}
