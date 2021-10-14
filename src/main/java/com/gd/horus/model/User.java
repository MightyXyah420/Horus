package com.gd.horus.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.gd.horus.util.RegisterDto;

import javax.persistence.JoinColumn;

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

    @ManyToMany(fetch = FetchType.EAGER)
    /*
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
            */  
    private Set<Role> authorities = new HashSet<>();

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the authorities
     */
    public Set<Role> getAuthorities() {
        return authorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public void addAuthority(Role role){
        this.authorities.add(role);
    }

    public void revokeAuthority(Role role){
        this.authorities.remove(role);
    }
    public User(RegisterDto reg){
        this.username = reg.getUsername();
        this.password = reg.getPassword();
    }
    public User(){
        super();
    }
}
