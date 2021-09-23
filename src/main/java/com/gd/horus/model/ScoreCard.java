package com.gd.horus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ScoreCard {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private int limbShotsA;
    private int limbShotsB;
    private int bodyShotsA;
    private int bodyShotsB;

}
