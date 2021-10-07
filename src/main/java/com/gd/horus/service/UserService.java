package com.gd.horus.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.gd.horus.model.Fighter;
import com.gd.horus.model.Role;
import com.gd.horus.model.User;
import com.gd.horus.repo.FightersRepo;
import com.gd.horus.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo usrRepo;

    @Autowired
    private FightersRepo fightersRepo;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createUser(User usr){
        usr.setPassword(this.passwordEncoder().encode(usr.getPassword()));
        return usrRepo.save(usr);
    }

    public Fighter creatFighter(Fighter fighter){
        return fightersRepo.save(fighter);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usrRepo.findByUsername(username).get();
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }
    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Set<Role> auths = user.getAuthorities();
        for (Role role : auths){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        /*
        user.getAuthorities().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        */
        return authorities;
    }
    public User getUserInfo(String username){
        Optional<User> qusr = usrRepo.findByUsername(username);
        if(qusr.isPresent()){
            return qusr.get();
        }else{
            return null;
        }
    }
}
