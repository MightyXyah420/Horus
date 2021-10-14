package com.gd.horus.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Fighter not existing in database")
public class NonExistingFighterException extends RuntimeException{
    
}
