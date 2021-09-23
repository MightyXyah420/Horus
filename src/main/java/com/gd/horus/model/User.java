package com.gd.horus.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.lang.NonNull;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @NonNull
    private String username;

    @Column
    private String password;

    @OneToOne
    private FighterInfo data;

    @ManyToMany
    private Set<Role> authorities;
}
