package com.gd.horus.util;

import com.gd.horus.model.FighterInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;


//<Process Input, Process Output >
public class FighterItemProcessor implements ItemProcessor <FighterDto, FighterInfo> {

    private static final Logger log = LoggerFactory.getLogger(FighterItemProcessor.class);

    @Override
    public FighterInfo process(FighterDto item) throws Exception {
        // TODO Auto-generated method stub
        log.info("Logginf info --- "+item.getContact()+" - "+item.getFullName());
        return new FighterInfo(item);
    }
    

    
}
