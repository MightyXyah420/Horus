package com.gd.horus.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/community")
public class CommunityControlller {
    @RequestMapping(value="/create_form", method = RequestMethod.POST)
    public void create(){
        
    }
    @RequestMapping(value="/get_forms", method = RequestMethod.POST)
    public void read(){
        
    }
    /**
     * method to process form answer
     */
    @RequestMapping(value="/forms/{}", method = RequestMethod.POST)
    public void answer(){
        
    }
}
