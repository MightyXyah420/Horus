package com.gd.horus.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.gd.horus.util.RegisterDto;

@Entity
public class Fighter extends User {
    
    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne
    private FighterInfo data;

    public FighterInfo getData() {
        return data;
    }

    public void setData(FighterInfo data) {
        this.data = data;
    }
    public Fighter(){
        super();
    }
    public Fighter(RegisterDto reg){
        super(reg);
    }
}
