package com.gd.horus.service;

import com.gd.horus.model.Fighter;
import com.gd.horus.model.User;
import com.gd.horus.repo.FightersRepo;
import com.gd.horus.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {
    @Autowired
    private UserRepo usrRepo;

    @Autowired
    private FightersRepo fightersRepo;

    public User createUser(User usr){
        return usrRepo.save(usr);
    }

    public Fighter creatFighter(Fighter fighter){
        return fightersRepo.save(fighter);
    }
}
