package com.gd.horus.service;

import java.util.Optional;

import com.gd.horus.model.Fighter;
import com.gd.horus.model.FighterInfo;
import com.gd.horus.repo.FightersRepo;
import com.gd.horus.repo.InfoRepo;
import com.gd.horus.repo.UserRepo;
import com.gd.horus.util.NonExistingFighterException;
import com.gd.horus.util.RegisterDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "fghtrService")
public class FightersService {
    @Autowired
    private FightersRepo fightersRepo;

    @Autowired
    private InfoRepo infoRepo;

    @Autowired 
    private UserRepo usrRepo;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public FighterInfo LinkFighter(String docNum, Fighter fighter){
        FighterInfo info = infoRepo.findByDoc(docNum);
        info.setFighter(fighter);
        return infoRepo.save(info);
    }
    
    public Boolean checkInfo(String docNum){
        try {
            FighterInfo fi = infoRepo.findByDoc(docNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public FighterInfo writeInfo(FighterInfo info ){
        return infoRepo.save(info);
    }
    public FighterInfo cleanInfo(){
        return infoRepo.save(new FighterInfo());
    }
    public Fighter cleanFighter(RegisterDto data){
        Fighter fg = new Fighter(data);
        fg.setPassword(this.passwordEncoder().encode(fg.getPassword()));
        return fightersRepo.save(fg);
    }
    public Fighter writeFighter(Fighter fighter){
        return fightersRepo.save(fighter);
    }
}

        /*
        FighterInfo fi = infoRepo.findByDoc(docNum);
        Fighter fighter = fightersRepo.findByUsername(usuName).get();
        System.out.println("fighter::: "+fighter.getUsername());
        System.out.println("Info::: "+fi.getDoc()+" +++ "+fi.getFighter().getUsername());
        fighter.setData(fi);
        fi.setFighter(fighter);
        fightersRepo.save(fighter);
        infoRepo.save(fi);
        return true;
        Optional<Fighter> fighter = fightersRepo.findByUsername(usuName);
        Fighter fg;
        if (fighter.isPresent()){
            fg = fighter.get();
        }else{
            throw new NonExistingFighterException();
        }
        FighterInfo temp;
        Optional<FighterInfo> fi = infoRepo.findByDoc(docNum);
        if(fi.isPresent()){
            temp = fi.get();
        }else{
            return false;
        }
        System.out.println("fighter info: "+ temp.getDoc()+" --- "+temp.getFighter().getUsername());
        fg.setData(temp);
        fightersRepo.save(fg);
        return true;
        */