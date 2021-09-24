package com.gd.horus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public void register(){
        
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void login(){
        
    }

    @RequestMapping(value="/changePassword", method = RequestMethod.POST)
    public void changePass(){
        
    }
}
