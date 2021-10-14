package com.gd.horus.util;

public class RegisterDto {
    private String username;
    private String password;
    private String doc;
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDoc() {
        return doc;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
    public RegisterDto(String username, String password, String doc) {
        this.username = username;
        this.password = password;
        this.doc = doc;
    }
    public RegisterDto(){
        super();
    }
}
