package com.gd.horus.controller;

import javax.servlet.http.HttpServletResponse;

import com.gd.horus.model.User;
import com.gd.horus.service.FightersService;
import com.gd.horus.service.UserService;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FightersService fghtrService;

    
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value="/test", method = RequestMethod.POST)
    @PreAuthorize("hasRole('admin')")
    public User example(){
        return null;
    }
}
