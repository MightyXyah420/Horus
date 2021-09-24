package com.gd.horus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/battle")
public class BattleController {
    @RequestMapping(value="/submit", method = RequestMethod.POST)
    public void register(){
        
    }
    @RequestMapping(value="/battles", method = RequestMethod.GET)
    public void getBattles(){
        
    }
    @RequestMapping(value="/battles/{fighter}", method = RequestMethod.POST)
    public void getBattlesBy(){
        
    }
}
