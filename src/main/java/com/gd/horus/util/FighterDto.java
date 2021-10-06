package com.gd.horus.util;

public class FighterDto {
    private String fullName;
    private String doc_num;
    private String doc_type;
    private String phone;
    private String email;
    private String addr;
    private String eps;
    private String rh;
    private String contact;
    public FighterDto (){
        super();
    }
    //public FighterDto(){}
    /**
     * @param fullName
     * @param doc_num
     * @param doc_type
     * @param phone
     * @param email
     * @param addr
     * @param rh
     */
    public FighterDto(String fullName, String doc_num, String doc_type, String phone, String email, String addr,
            String rh) {
        this.fullName = fullName;
        this.doc_num = doc_num;
        this.doc_type = doc_type;
        this.phone = phone;
        this.email = email;
        this.addr = addr;
        this.rh = rh;
    }
    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * @return the doc_num
     */
    public String getDoc_num() {
        return doc_num;
    }
    /**
     * @param doc_num the doc_num to set
     */
    public void setDoc_num(String doc_num) {
        this.doc_num = doc_num;
    }
    /**
     * @return the doc_type
     */
    public String getDoc_type() {
        return doc_type;
    }
    /**
     * @param doc_type the doc_type to set
     */
    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }
    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * @return the addr
     */
    public String getAddr() {
        return addr;
    }
    /**
     * @param addr the addr to set
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }
    /**
     * @return the rh
     */
    public String getRh() {
        return rh;
    }
    /**
     * @param rh the rh to set
     */
    public void setRh(String rh) {
        this.rh = rh;
    }
    public String getEps() {
        return eps;
    }
    public void setEps(String eps) {
        this.eps = eps;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
