package com.gd.horus.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fighters")
public class FightersController {
    @RequestMapping(value="/fillData", method = RequestMethod.POST)
    public void fillFighterInfo(){
        
    }
    @RequestMapping(value="/assistance", method = RequestMethod.POST)
    public void assistance(){
        
    }
    @RequestMapping(value="/group_assistance", method = RequestMethod.POST)
    public void group_assistance(){
        
    }
    
}
