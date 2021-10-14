package com.gd.horus.controller;

import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletResponse;

import com.gd.horus.model.Fighter;
import com.gd.horus.model.FighterInfo;
import com.gd.horus.model.User;
import com.gd.horus.security.TokenProvider;
import com.gd.horus.service.FightersService;
import com.gd.horus.service.UserService;
import com.gd.horus.util.AuthToken;
import com.gd.horus.util.Login;
import com.gd.horus.util.NotAuthException;
import com.gd.horus.util.RegisterDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService usrService;

    @Autowired
    private FightersService fightersService;

    @Autowired
    private TokenProvider jwtTokenUtil;
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public Fighter register(@RequestBody RegisterDto body){
        
        Fighter fighter = fightersService.cleanFighter(body);
        if(fightersService.checkInfo(body.getDoc())){
            System.out.println("entra if");
            FighterInfo cleanSheet = fightersService.LinkFighter(body.getDoc(), fighter);
            System.out.println("!!!!   "+cleanSheet.getPhone());
            fighter.setData(cleanSheet);
            return fightersService.writeFighter(fighter);
        }else{
            System.out.println("entra else");
            FighterInfo cleanSheet = fightersService.cleanInfo();
            cleanSheet.setDoc(body.getDoc());
            cleanSheet.setFighter(fighter);
            cleanSheet = fightersService.writeInfo(cleanSheet);
            fighter.setData(cleanSheet);
            return fightersService.writeFighter(fighter);
        }
        
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public void login(){
        
    }

    @RequestMapping(value="/changePassword", method = RequestMethod.POST)
    public void changePass(){
        
    }
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody Login loginUser) throws AuthenticationException {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
    @RequestMapping(value="/test", method = RequestMethod.POST)
    public User test(HttpServletResponse response) throws IOException{
        System.out.println("entra");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        System.out.println("entra");
        log.info(auth.getName());
        log.info(auth.toString());
        log.info(auth.getCredentials().toString());
        log.info(auth.getDetails().toString());
        User retorno = usrService.getUserInfo(auth.getName());
        if(retorno == null){
            throw new NotAuthException();
        }else{
            return retorno;
        }
    }
    
}
