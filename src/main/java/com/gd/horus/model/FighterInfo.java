package com.gd.horus.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;

import com.gd.horus.util.Doc;
import com.gd.horus.util.FighterDto;

@Entity
public class FighterInfo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String fullName;

    @Column
    private String doc_num;

    @Enumerated(EnumType.ORDINAL)
    private Doc doc_type;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String addr;

    @Column
    private String rh;

    @Column
    private String contact;

    @ElementCollection
    @MapKeyColumn(name="house")
    @Column(name="trainings")
    @CollectionTable(name="house_trainings", joinColumns=@JoinColumn(name="keep_up_MF"))
    private Map <String, Integer> trainings = new HashMap<String, Integer>();

    @ManyToOne
    private Insurance insurance; 

    @Column
    private int faults;
    
    @Column
    private int sessions;

    @Column
    private int wars;

    @Column
    private int elo;

    public FighterInfo (){
        super();
    } 
    public FighterInfo(FighterDto data){
        this.addr = data.getAddr();
        this.doc_num = data.getDoc_num();
        this.email = data.getEmail();
        this.fullName = data.getFullName();
        this.phone = data.getPhone();
        this.rh = data.getRh();
    }
    /**
     * @return the contact
     */
    public String getContact() {
        return contact;
    }
    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
     * @return the insurance
     */
    public Insurance getInsurance() {
        return insurance;
    }
    /**
     * @param insurance the insurance to set
     */
    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
    /**
     * @return the faults
     */
    public int getFaults() {
        return faults;
    }
    /**
     * @param faults the faults to set
     */
    public void setFaults(int faults) {
        this.faults = faults;
    }
    /**
     * @return the sessions
     */
    public int getSessions() {
        return sessions;
    }
    /**
     * @param sessions the sessions to set
     */
    public void setSessions(int sessions) {
        this.sessions = sessions;
    }
    /**
     * @return the wars
     */
    public int getWars() {
        return wars;
    }
    /**
     * @param wars the wars to set
     */
    public void setWars(int wars) {
        this.wars = wars;
    }
    /**
     * @return the elo
     */
    public int getElo() {
        return elo;
    }
    /**
     * @param elo the elo to set
     */
    public void setElo(int elo) {
        this.elo = elo;
    }
    
}
